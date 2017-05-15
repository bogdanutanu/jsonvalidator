# Json Validator

This tool is aimed at validating JSON files when the content is too big, or unconvenient, to be
uploaded to a typical online Json parser.

It's written in Java 8 and uses GSON to attempt to parse each entry.

Usage: java -jar jsonvalidator <path-to-json-file>