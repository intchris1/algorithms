package com.algorithms.chris.neetcode.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Дана строка, нужно найти самуд длинную подстроку без повторяющихся символов.
 * Использовать алгоритм slidingWindow - перемещать левый указатель до последнего неповторяющегося символа.
 * <p>
 * Given a string, find longest substring without repeating characters.
 * Solution - sliding window algorithm. Move a leftPointer to the last not repeating character.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    // решение с мапой
    public static int lengthOfLongestSubstring(String s) {
        int currentSubstringLength = 0;
        int maxSubstringLength = 0;
        int indexOfSubstringBeginning = 0;
        Map<Character, Integer> currentlyAccumulatedChars = new HashMap<>();
        var chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            var previousIndexOfRepetition = currentlyAccumulatedChars.put(chars[i], i);
            currentSubstringLength++;
            if (previousIndexOfRepetition != null && previousIndexOfRepetition >= indexOfSubstringBeginning) {
                currentSubstringLength = i - previousIndexOfRepetition;
                indexOfSubstringBeginning = previousIndexOfRepetition + 1;
            }
            if (currentSubstringLength > maxSubstringLength) maxSubstringLength = currentSubstringLength;
        }
        return maxSubstringLength;
    }

    // решение с сетом
    public static int lengthOfLongestSubstringWithSet(String s) {
        Set<Character> charsSet = new HashSet<>();
        int result = 0;
        int leftPointer = 0;
        var chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            var aChar = chars[i];
            while (charsSet.contains(aChar)) {
                charsSet.remove(chars[leftPointer]);
                leftPointer++;
            }
            charsSet.add(aChar);
            int currentStringLength = i - leftPointer + 1;
            if (currentStringLength > result) {
                result = currentStringLength;
            }
        }
        return result;
    }

}
