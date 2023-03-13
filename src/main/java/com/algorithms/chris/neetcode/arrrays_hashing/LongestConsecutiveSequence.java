package com.algorithms.chris.neetcode.arrrays_hashing;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int current = 1;
        int max = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            var difference = nums[i + 1] - nums[i];
            if (difference == 1) {
                current++;
            } else if (difference != 0) {
                current = 1;
            }
            if (current > max) {
                max = current;
            }
        }
        return max;
    }
}
