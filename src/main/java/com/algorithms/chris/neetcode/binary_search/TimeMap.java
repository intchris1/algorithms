package com.algorithms.chris.neetcode.binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Сделать структуру данных, которая может хранить несколько значений для каждого ключа и в разный timestamp.
 * <p>
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
 */
public class TimeMap {

    private final Map<String, List<String>> map1 = new HashMap<>();
    private final Map<String, List<Integer>> map2 = new HashMap<>();

    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {
        map1.computeIfAbsent(key, l -> new ArrayList<>()).add(value);
        map2.computeIfAbsent(key, l -> new ArrayList<>()).add(timestamp);
    }

    public String get(String key, int timestamp) {
        var value = map1.get(key);
        if (value == null) {
            return "";
        }
        var timeStamps = map2.get(key);
        var values = map1.get(key);
        var result = Collections.binarySearch(timeStamps, timestamp);
        if (result >= 0) {
            return values.get(result);
        } else if (result < -1) {
            return values.get(-(result + 2));
        } else {
            return "";
        }
    }
}