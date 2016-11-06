package io.github.satr.training.compress;

import java.util.Arrays;

public class StringCompressor {
    public String compress(String input) {
        return compressWithStringBuffer(input);
//        return compressWithArray(input);
    }

    public String compressWithArray(String input) {
        if(input == null)
            return null;
        int inputLength = input.length();
        if(inputLength < 2)
            return input;
        char[] outChars = new char[inputLength];
        int outIndex = 0;
        outChars[0] = input.charAt(0);
        int count = 1;
        for (int inIndex = 1; inIndex < inputLength; inIndex++) {
            if(outChars[outIndex] == input.charAt(inIndex)) {
                count++;
                continue;
            }
            String chCount = Integer.toString(count);
            for (int j = 0; j < chCount.length(); j++) { //TODO: left code repeaded below
                outIndex++;
                if(outIndex >= inputLength)
                    return input;//new string is longer than input string
                outChars[outIndex] = chCount.charAt(j);
            }
            outIndex++;
            if(outIndex >= inputLength)
                return input;//new string is longer than input string
            outChars[outIndex] = input.charAt(inIndex);
            count = 1;
        }
        String chCount = Integer.toString(count);
        for (int j = 0; j < chCount.length(); j++) { //TODO: left code repeaded above
            outIndex++;
            if(outIndex >= inputLength)
                return input;//new string is longer than input string
            outChars[outIndex] = chCount.charAt(j);
        }
        return new String(Arrays.copyOfRange(outChars, 0, outIndex + 1));
    }

    public String compressWithStringBuffer(String input) {
        if(input == null)
            return null;
        if(input.length() < 2)
            return input;
        StringBuffer sb = new StringBuffer();
        char lastChar = input.charAt(0);
        sb.append(lastChar);
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(lastChar == ch) {
                count++;
                continue;
            }
            sb.append(count);
            sb.append(ch);
            lastChar = ch;
            count = 1;
        }
        sb.append(count);
        String output = sb.toString();
        return output.length() > input.length() ? input: output;
    }
}
