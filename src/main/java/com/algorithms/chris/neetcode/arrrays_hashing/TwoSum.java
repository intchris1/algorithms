package com.algorithms.chris.neetcode.arrrays_hashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int otherNumber = target - nums[i];
            var otherNumberInMap = map.get(otherNumber);
            if (otherNumberInMap != null) {
                return new int[]{otherNumberInMap, i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}

