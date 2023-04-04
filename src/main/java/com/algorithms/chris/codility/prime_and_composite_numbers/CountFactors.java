package com.algorithms.chris.codility.prime_and_composite_numbers;

/**
 * Посчитать количество делителей числа.
 * <p>
 * Оптимизированное решение - проверять все числа только до sqrt(N), потому что у каждого делителя есть симметричный делитель.
 * Один из них меньше sqrt(N), а другой больше.
 * <p>
 * Count divisors of given number.
 * <p>
 * Optimized solution - check all numbers before sqrn(N), because each divisor has a symmetric divisor.
 * One of them is less than sqrt(N), the other one is more than it.
 */
public class CountFactors {

    public static int solution(int N) {
        int factors = 0;
        int i = 1;
        for (; i < Math.sqrt(N); i++) {
            if (N % i == 0) {
                factors += 2;
            }
        }
        if (i * i == N) {
            factors++;
        }
        return factors;
    }
}

