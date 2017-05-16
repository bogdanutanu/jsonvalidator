package com.bogdanutanu;


import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class ValidateJsonInFile {

    private static JsonParser jsonParser = new JsonParser();

    public static void main(String[] args) {

        if (args.length != 1){
            System.err.println("Usage: java -jar jsonvalidator <path-to-json-file>");
            System.exit(1);
        }

        String fileName = args[0];

        try (Stream<String> stream = Files.lines(Paths.get(fileName))){
            stream.map(ValidateJsonInFile::filterInvalid).forEach(o -> o.ifPresent(System.out::println));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Optional<String> filterInvalid(String json) {
        try {
            jsonParser.parse(json);
            return Optional.empty();
        } catch(JsonSyntaxException e) {
            return Optional.of(json);
        }
    }
}
