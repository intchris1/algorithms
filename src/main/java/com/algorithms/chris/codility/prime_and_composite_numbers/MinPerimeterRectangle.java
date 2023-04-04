package com.algorithms.chris.codility.prime_and_composite_numbers;

/**
 * Find the minimal perimeter of any rectangle whose area equals N.
 */
public class MinPerimeterRectangle {

    public static int solution(int N) {
        for (int i = (int) Math.sqrt(N); i > 0; i--) {
            if (N % i == 0) {
                return 2 * (N / i + i);
            }
        }
        return 0;
    }
}
