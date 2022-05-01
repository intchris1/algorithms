package com.algorithms.chris.prefix_sums;

public class PassingCars {
    public static int solution(int[] A) {
        long pairs = 0;
        int passedOnes = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 1) {
                passedOnes++;
            } else if (passedOnes > 0) {
                pairs += passedOnes;
            }
        }
        if (pairs > 1_000_000_000) {
            pairs = -1;
        }
        return (int) pairs;
    }
}
