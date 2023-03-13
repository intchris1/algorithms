package com.algorithms.chris.neetcode.arrrays_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            var chars = str.toCharArray();
            Arrays.sort(chars);
            var sortedString = new String(chars);
            var group = map.computeIfAbsent(sortedString, k -> new ArrayList<>());
            group.add(str);
        }
        return new ArrayList<>(map.values());
    }
}

