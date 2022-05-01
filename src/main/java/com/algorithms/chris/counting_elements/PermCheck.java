package com.algorithms.chris.counting_elements;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {
    public static int solution(int[] A) {
        final Set<Integer> set = new HashSet<>(A.length);
        int max = 0;
        for (int value : A) {
            boolean fresh = set.add(value);
            if (max < value) {
                max = value;
            }
            if (!fresh) {
                return 0;
            }
        }
        if (set.contains(1) && max - set.size() == 0) {
            return 1;
        }
        return 0;
    }
}
