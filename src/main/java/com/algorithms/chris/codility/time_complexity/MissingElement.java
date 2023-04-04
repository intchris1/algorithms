package com.algorithms.chris.codility.time_complexity;

import java.util.Arrays;

public class MissingElement {

    public static int solution(int[] nums) {
        if (nums.length == 0) return 1;
        if (nums.length == 1) return nums[0] == 1 ? 2 : 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }
        return nums[0] == 1 ? nums[nums.length - 1] + 1 : 1;
    }
}
