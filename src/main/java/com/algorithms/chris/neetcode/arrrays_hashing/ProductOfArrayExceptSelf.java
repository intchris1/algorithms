package com.algorithms.chris.neetcode.arrrays_hashing;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        int[] postfix = new int[nums.length];
        postfix[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i];
        }
        int[] result = new int[nums.length];
        for (int i = 1; i < result.length - 1; i++) {
            result[i] = prefix[i - 1] * postfix[i + 1];
        }
        result[0] = postfix[1];
        result[result.length - 1] = prefix[result.length - 2];
        return result;
    }
}
