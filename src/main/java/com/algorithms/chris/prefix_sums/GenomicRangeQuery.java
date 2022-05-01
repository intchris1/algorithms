package com.algorithms.chris.prefix_sums;

/**
 * Нужно найти нуклеотид с минимальным влиянием на указанном отрезке
 * 1. Создать 2д массив вида (для строки ACCAGT):
 * A C G
 * 0 0 0
 * 1 0 0
 * 1 1 0
 * 1 2 0
 * 2 2 0
 * 2 2 1
 * 2 2 1
 * вести счетчик каждому нуклеотиду в этом массиве, тогда, если нужно узнать, появился ли конкретный нуклеотид на отрезке,
 * достаточно сравнить значения массива для указанных индексов
 */
public class GenomicRangeQuery {
    public static int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];
        char[] chars = S.toCharArray();
        int[][] counters = new int[4][S.length() + 1];
        int countOfA = 0;
        int countOfC = 0;
        int countOfG = 0;
        for (int i = 0; i < chars.length; i++) {
            char nuc = chars[i];
            if ('A' == nuc) countOfA++;
            if ('C' == nuc) countOfC++;
            if ('G' == nuc) countOfG++;
            counters[0][i + 1] = countOfA;
            counters[1][i + 1] = countOfC;
            counters[2][i + 1] = countOfG;
        }
        for (int i = 0; i < result.length; i++) {
            int beginIndex = P[i];
            int endIndex = Q[i];
            int minimumNucleotid = 4;
            for (int nucleotidIndex = 0; nucleotidIndex < 3; nucleotidIndex++) {
                boolean isNucleotidPresent = counters[nucleotidIndex][endIndex + 1] != counters[nucleotidIndex][beginIndex];
                if (isNucleotidPresent) {
                    minimumNucleotid = nucleotidIndex + 1;
                    break;
                }
            }
            result[i] = minimumNucleotid;
        }
        return result;
    }
}
