package io.github.satr.training.compress;

public class Main {

    public static void main(String[] args) {
        StringCompressor compressor = new StringCompressor();
        String input = "aaabbc";
        String result = compressor.compressWithArray(input);
        System.out.printf("String \"%s\" compressed to \"%s\" with array.\n", input, result);
        result = compressor.compressWithStringBuffer(input);
        System.out.printf("String \"%s\" compressed to \"%s\" with string buffer.\n", input, result);
        System.out.println("Run unit-tests.");
    }
}
