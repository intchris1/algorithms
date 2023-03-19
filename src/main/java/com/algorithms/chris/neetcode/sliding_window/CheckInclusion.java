package com.algorithms.chris.neetcode.sliding_window;

/**
 * Проверить, содержится ли во второй строке анаграмма первой.
 * Решение - держать два массива со счетчиками, одна для первой строки, другая для текущего окна.
 * При движении окна проверять, как изменилось совпадение всех букв алфавита.
 * Увеличивать количество совпадений на 1, если появилось новое,
 * уменьшать количество совпадений, если счетчик увеличился/уменьшился на один. Строго на один!
 * <p>
 * Check if s2 contains s1 permutation.
 * Solution - keep two arrays with counters, one for the first string, one for a current window.
 * While moving the window, check how matches of all letters changed.
 * Increment matches by one, if there is a new match,
 * Decrement matches by one, if the counter increased/decreased by one. Strictly by one!
 */
public class CheckInclusion {

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1map[i] == s2map[i])
                count++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int right = s2.charAt(i + s1.length()) - 'a';
            int left = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[right]++;
            if (s2map[right] == s1map[right]) {
                count++;
            } else if (s2map[right] == s1map[right] + 1) {
                count--;
            }
            s2map[left]--;
            if (s2map[left] == s1map[left]) {
                count++;
            } else if (s2map[left] == s1map[left] - 1) {
                count--;
            }
        }
        return count == 26;
    }
}
