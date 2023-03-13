package com.algorithms.chris.neetcode.arrrays_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            var current = map.get(num);
            if (current == null) current = 0;
            current++;
            map.put(num, current);
        }
        var list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }
}

