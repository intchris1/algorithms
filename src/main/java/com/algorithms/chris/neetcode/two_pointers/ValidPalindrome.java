package com.algorithms.chris.neetcode.two_pointers;

/**
 * Проверить, валиндный ли палиндром (исключая не буквы и не цифры, в нижнем регистре)
 * Решение - использовать алгоритм two pointers.
 * <p>
 * Check if palindrome is valid (comparing only alphanumeric characters lowercase)
 * Solution - two pointers algorithm.
 */
public class ValidPalindrome {

    public static boolean validPalindrome(String s) {
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && !Character.isLetterOrDigit(s.charAt(leftIndex))) {
                leftIndex++;
            }
            while (leftIndex < rightIndex && !Character.isLetterOrDigit(s.charAt(rightIndex))) {
                rightIndex--;
            }
            if (leftIndex < rightIndex && Character.toLowerCase(s.charAt(leftIndex)) != Character.toLowerCase(s.charAt(rightIndex))) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}
