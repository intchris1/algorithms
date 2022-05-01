package com.algorithms.chris.counting_elements;

import java.util.Arrays;

public class MissingInteger {
    public static int solution(int[] A) {
        int smallestPositiveMissing = 1;
        Arrays.sort(A);
        for (int value : A) {
            if (value == smallestPositiveMissing) {
                smallestPositiveMissing++;
            }
        }
        return smallestPositiveMissing;
    }

}
