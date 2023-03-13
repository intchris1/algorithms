package com.algorithms.chris.neetcode.two_pointers;

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
