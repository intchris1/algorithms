package com.algorithms.chris.codility.counting_elements;

import java.util.HashSet;

public class FrogRiverOne {
    public static int solution(int X, int[] A) {
        final var set = new HashSet<>(X);
        for (int i = 0; i < A.length; i++) {
            int current = A[i];
            if (current <= X) {
                set.add(current);
            }
            if (set.size() == X) {
                return i;
            }
        }
        return -1;
    }
}
