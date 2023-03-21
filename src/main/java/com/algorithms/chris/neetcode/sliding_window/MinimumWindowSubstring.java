package com.algorithms.chris.neetcode.sliding_window;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Нужно найти минимальную подстроку, в которой содержатся все символы из целевой строки.
 * Решение - алгоритм sliding window.
 * 1) Завести мапу со счетчиками количества символов в целевой строке.
 * 2) Отфильтровать символы из сроки для поиска - удалить из нее те, которые не присутствуют в целевой строке. Сложить символы вместе с индексами в список.
 * 3) Завести мапу со счетчиками символов под текущее окно.
 * 4) Инкрементить счетчик найденных символов, если счетчик для символов в окне совпадает с целевым.
 * 5) Если все символы найдены, пора двигать левый указатель. (Обновить найденную длину подстроки, если найдена более короткая).
 * Понижать счетчик найденных символов, если какой-то буквы стало меньше, чем нужно.
 * 6) Перестать двигать левый указатель, если буквы не хватает.
 * <p>
 * Find the minimum window substring containing all symbols from target string.
 * Solution - sliding window algorithm.
 * 1) Build a map with counters for each symbol from a target string.
 * 2) Filter out symbols from the search string - delete symbols that are not present in a target string. Put them in a list with their indexes.
 * 3) Build a map with counters for a current window.
 * 4) Increment a counter for all symbols, if one symbol counter matches the target count.
 * 5) If all symbols are found, move a left pointer. (Update minimum substring length, if there is a shorter substring found).
 * Decrement found symbols counter, if one symbol counter doesn't matches the target count anymore.
 * 6) Stop moving a left pointer, if one symbol lost.
 */
public class MinimumWindowSubstring {

    public static String minWindowPassingSolution(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.compute(c, (k, v) -> {
                if (v == null) v = 0;
                return ++v;
            });
        }
        int required = targetMap.size();
        List<Map.Entry<Integer, Character>> filteredExaminedString = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (targetMap.containsKey(c)) {
                filteredExaminedString.add(new AbstractMap.SimpleEntry<>(i, c));
            }
        }

        int left = 0;
        int right = 0;
        int formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0};

        while (right < filteredExaminedString.size()) {
            char currentChar = filteredExaminedString.get(right).getValue();
            windowCounts.compute(currentChar, (k, v) -> {
                if (v == null) v = 0;
                return ++v;
            });

            if (targetMap.containsKey(currentChar) && Objects.equals(windowCounts.get(currentChar), targetMap.get(currentChar))) {
                formed++;
            }

            while (left <= right && formed == required) {
                currentChar = filteredExaminedString.get(left).getValue();
                int end = filteredExaminedString.get(right).getKey();
                int start = filteredExaminedString.get(left).getKey();
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }
                windowCounts.compute(currentChar, (k, v) -> --v);
                if (targetMap.containsKey(currentChar) && windowCounts.get(currentChar) < targetMap.get(currentChar)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static String minWindowMySolution(String s, String t) {
        if (t.length() > s.length()) return "";
        var targetMap = new HashMap<Character, Integer>();
        for (int i = 0; i < t.toCharArray().length; i++) {
            targetMap.compute(t.charAt(i), (k, v) -> {
                if (v == null) v = 0;
                return ++v;
            });
        }
        var currentWindowMap = new HashMap<Character, Integer>();
        int lettersLeft = t.length();
        int left = 0;
        int resultSubstringBeginning = -1;
        int resultSubstringEnd = -1;
        for (int right = 0; right < s.toCharArray().length; right++) {
            var currentLetter = s.charAt(right);
            var currentCountOfLetterInWindow = currentWindowMap.compute(currentLetter, (k, v) -> {
                if (v == null) v = 0;
                return ++v;
            });
            var countOfLetterInTarget = targetMap.get(currentLetter);
            if (countOfLetterInTarget != null && currentCountOfLetterInWindow <= countOfLetterInTarget) {
                if (lettersLeft == t.length()) {
                    left = right;
                }
                lettersLeft--;
                if (lettersLeft == 0) {
                    resultSubstringBeginning = left;
                    resultSubstringEnd = right;
                }
            } else if (countOfLetterInTarget != null) {
                var currentLeftLetter = s.charAt(left);
                if (currentLeftLetter == currentLetter) {
                    while (left < right) {
                        var leftChar = s.charAt(left);
                        currentWindowMap.compute(leftChar, (k, v) -> --v);
                        left++;
                        leftChar = s.charAt(left);
                        var currentCount = currentWindowMap.get(leftChar);
                        var targetCount = targetMap.get(leftChar);
                        if (targetCount != null && targetCount >= currentCount) {
                            if (lettersLeft == 0 && right - left < resultSubstringEnd - resultSubstringBeginning) {
                                resultSubstringBeginning = left;
                                resultSubstringEnd = right;
                            }
                            break;
                        }
                    }
                }
            }
        }
        if (resultSubstringEnd != -1) {
            return s.substring(resultSubstringBeginning, resultSubstringEnd + 1);
        }
        return "";
    }
}
