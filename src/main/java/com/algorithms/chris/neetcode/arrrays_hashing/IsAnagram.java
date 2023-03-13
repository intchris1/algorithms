package com.algorithms.chris.neetcode.arrrays_hashing;

import java.util.Arrays;

public class IsAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        var charsOfFirstString = s.toCharArray();
        Arrays.sort(charsOfFirstString);
        var charsOfSecondString = t.toCharArray();
        Arrays.sort(charsOfSecondString);
        for (int i = 0; i < charsOfFirstString.length; i++) {
            if (charsOfFirstString[i] != charsOfSecondString[i]) return false;
        }
        return true;
    }
}

