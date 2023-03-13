package com.algorithms.chris.neetcode.arrrays_hashing;

import java.util.HashSet;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        var set = new HashSet<>();
        for (int num : nums) {
            var unique = set.add(num);
            if (!unique) return true;
        }
        return false;
    }
}

