package com.algorithms.chris.codility.counting_elements;

public class MaxCounters {

    public static int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int currentMax = 0;
        int lastUpdate = 0;
        final int setAllToMaxCounter = N + 1;

        for (int currentValue : A) {
            if (currentValue == setAllToMaxCounter) {
                lastUpdate = currentMax;
            } else {
                int counterIndex = currentValue - 1;
                if (counters[counterIndex] < lastUpdate) {
                    counters[counterIndex] = lastUpdate;
                }
                counters[counterIndex]++;
                if (counters[counterIndex] > currentMax) {
                    currentMax = counters[counterIndex];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (counters[i] < lastUpdate) {
                counters[i] = lastUpdate;
            }
        }
        return counters;
    }
}
