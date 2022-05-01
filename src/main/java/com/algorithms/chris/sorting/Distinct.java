package com.algorithms.chris.sorting;

import java.util.HashSet;

public class Distinct {

    public static int solution(int[] A) {
        var set = new HashSet<>(A.length);
        for (int i : A) {
            set.add(i);
        }
        return set.size();
    }
}
