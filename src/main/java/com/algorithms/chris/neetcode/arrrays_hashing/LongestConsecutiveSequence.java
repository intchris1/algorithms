package com.algorithms.chris.neetcode.arrrays_hashing;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        int current = 1;
        int max = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                current++;
            } else {
                current = 1;
            }
            if (current > max) {
                max = current;
            }
        }
        if (max == 1) return 0;
        return max;
    }
}
