package com.algorithms.chris.prefix_sums;

/**
 * Нужно найти индекс начала слайса массива с наименьшим средним арифметическим
 * Я не до конца понимаю, но примерно так:
 * нет смысла проверять слайсы размером в 4, 5, 6 элементов и тд, потому что любой такой слайс может быть разбит на подслайсы
 * из 2-3 элементов, и в каком-то из них будет минимальное среднее
 */
public class MinAvgTwoSlices {

    public static int solution(int[] A) {
        if (A.length == 2) return 0;
        int minSumTwo = A[0] + A[1];
        int minSumThree = minSumTwo + A[2];
        int indexTwo = 0;
        int indexThree = 0;
        for (int i = 1; i < A.length - 1; i++) {
            int sumTwo = A[i] + A[i + 1];
            if (sumTwo < minSumTwo) {
                minSumTwo = sumTwo;
                indexTwo = i;
            }
            if (i < A.length - 2) {
                int sumThree = sumTwo + A[i + 2];
                if (sumThree < minSumThree) {
                    minSumThree = sumThree;
                    indexThree = i;
                }
            }
        }
        final double minAvgForTwo = (double) minSumTwo / 2;
        final double minAvgForThree = (double) minSumThree / 3;
        if (minAvgForTwo < minAvgForThree) {
            return indexTwo;
        } else if (minAvgForThree == minAvgForTwo) {
            return Math.min(indexTwo, indexThree);
        } else {
            return indexThree;
        }
    }

    public static int solutionSlow(int[] A) {
        double[] accumulatedSums = new double[A.length];
        double minAverage = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            int currentNumber = A[i];
            accumulatedSums[i] = currentNumber;
            for (int j = 0; j < i; j++) {
                accumulatedSums[j] += currentNumber;
                int numOfElements = (i - j + 1);
                double average = accumulatedSums[j] / numOfElements;
                if (average < minAverage) {
                    minAverage = average;
                    result = j;
                }
            }
        }
        return result;
    }


}
