package com.algorithms.chris.neetcode.sliding_window;

import java.util.HashMap;

import static java.lang.Math.min;

/**
 * Дана строка, нужно найти длину самой длинной подстроки с повторяющимися символами при условии, что в строке можно заменить k символов на нужную букву.
 * Использовать алгоритм slidingWindow - перемещать левый указатель до последнего неповторяющегося символа.
 * Решение - sliding window алгоритм.
 * 1) Завести левые и правые указатели
 * 2) Заполнять мапу с количеством символов для каждой буквы
 * 3) Передвигать правый указатель, проверять, валидно ли окно (длина окна - кол-во самого часто повторяющегося элемента в окне <= k)
 * 4) ВАЖНО, но я этого не поняла. Не обязательно при сокращении окна после передвижения левого указателя пересчитывать, сколько повторяется самый частый элемент.
 * Достаточно изменять его при появлении нового самого частого элемента.
 * <p>
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * Solution - sliding window algorithm&
 * 1) Define two pointers (left and right)
 * 2) Have a hash map - each character to its frequency in current window
 * 3) Move right pointer, check if the window is valid (window length - count of most frequent element <= k)
 * 4) IMPORTANT, but I don't get it: it's not necessary to recalculate most frequent element count every time you move the left pointer.
 * You can just change it every time you have a new most frequent element.
 */
public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        int result = 0;
        var chars = s.toCharArray();
        var counts = new HashMap<Character, Integer>();
        int left = 0;
        int mostFrequentElemCount = 0;
        for (int right = 0; right < chars.length; right++) {
            var count = counts.compute(chars[right], (key, val) -> {
                if (val == null) val = 0;
                val++;
                return val;
            });
            if (count > mostFrequentElemCount) {
                mostFrequentElemCount = count;
            }
            int windowLength = right - left + 1;
            int replacementsNeeded = windowLength - mostFrequentElemCount;
            while (replacementsNeeded > k && left < right) {
                counts.compute(chars[left], (key, val) -> --val);
                left++;
                windowLength = right - left + 1;
                replacementsNeeded = windowLength - mostFrequentElemCount;
            }
            if (windowLength > result) {
                result = windowLength;
            }
        }
        return result;
    }

    public static int characterReplacementBruteForce(String s, int k) {
        int result = 0;
        var chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            var aChar = chars[i];
            int currLength = 1;
            int replacements = 0;
            for (int j = i + 1; j < chars.length; j++) {
                var nextChar = chars[j];
                if (nextChar != aChar && replacements < k) {
                    nextChar = aChar;
                    replacements++;
                }
                if (nextChar == aChar) {
                    currLength++;
                } else {
                    break;
                }
            }
            currLength += min(k - replacements, i);
            if (currLength > result) {
                result = currLength;
            }
        }
        return result;
    }
}
