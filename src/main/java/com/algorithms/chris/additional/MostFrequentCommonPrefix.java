package com.algorithms.chris.additional;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class MostFrequentCommonPrefix {
    public static String mostFrequentCommonPrefix(String[] arg) {
        if (arg.length == 0) return "";
        if (arg.length == 1) return arg[0];
        int currentCharIndex = 0;
        StringBuilder prefixAccumulator = new StringBuilder();
        MostFrequentElement previous = null;
        boolean stop = false;
        while (!stop) {
            StringBuilder prefixProcessor = new StringBuilder();
            for (String current : arg) {
                if (current.length() > currentCharIndex) {
                    prefixProcessor.append(current.charAt(currentCharIndex));
                }
            }
            char[] chars = prefixProcessor.toString().toCharArray();
            MostFrequentElement mostFrequentElement = findMostFrequentElement(chars);
            if (mostFrequentElement.occurence != 0 && (previous == null || previous.occurence <= mostFrequentElement.occurence)) {
                previous = mostFrequentElement;
                prefixAccumulator.append(mostFrequentElement.aChar);
                currentCharIndex++;
            } else {
                stop = true;
            }
        }
        return prefixAccumulator.toString();

    }

    private static MostFrequentElement findMostFrequentElement(char[] chars) {
        if (chars.length == 0) return new MostFrequentElement().withOccurence(0);
        int max = 0;
        char mostFrequent = chars[0];
        int currentCount = 0;
        for (int i = 0; i < chars.length - 2; i++) {
            if (chars[i] == chars[i + 1]) {
                currentCount++;
                if (currentCount > max) {
                    max = currentCount;
                    mostFrequent = chars[i];
                }
            } else {
                currentCount = 0;
            }
        }
        return new MostFrequentElement(mostFrequent, max);
    }


    @AllArgsConstructor
    @NoArgsConstructor
    private static class MostFrequentElement {
        private char aChar;
        private int occurence;

        private MostFrequentElement withOccurence(int occurence) {
            this.occurence = occurence;
            return withOccurence(occurence);
        }
    }
}
