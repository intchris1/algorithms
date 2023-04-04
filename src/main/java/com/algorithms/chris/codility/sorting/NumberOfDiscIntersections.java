package com.algorithms.chris.codility.sorting;

/**
 * Каждый элемент - круг, индекс элемента - где он расположен на отрезке, значение элемента - его радиус
 * Нужно посчитать, со сколькими кругами он пересекается, вернуть количество пересекающихся пар
 * Глобально - для каждого круга K найти все круги, отвечающие условиям:
 * 1) левая граница меньше или равна правой границе K,
 * 2) находятся справа от центра K.
 * 1) Составить массив со счетчиком кругов, у которых левая граница находится левее i
 * 1.1. Отметить на массиве левые границы всех кругов
 * 1.2. Пройтись по массиву и на каждом i накопить количество левых границ (префиксная сумма)
 * 2) Для каждого K:
 * 2.1. Найти правую границу.
 * 2.2. Из массива в пункте 1) достать все круги с левой границей меньше правой границы K
 * 2.3. Оставить только те круги, которые находятся справа от центра К
 * Мы знаем, что левее K находится i кругов + 1 (включая сам K), поэтому просто вычитаем i + 1
 * Итоговое число - количество пересечений
 **/
public class NumberOfDiscIntersections {
    public static int solution(int[] A) {
        int numberOfIntersections = 0;
        int[] leftBorders = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int radius = A[i];
            int leftBorder = Math.max(i - radius, 0);
            leftBorders[leftBorder]++;
        }
        for (int i = 1; i < leftBorders.length; i++) {
            leftBorders[i] += leftBorders[i - 1];
        }
        for (int i = 0; i < A.length; i++) {
            int radius = A[i];
            int rightBorder = (int) Math.min(i + (long) radius, (long) A.length - 1);
            int intt = Math.max(leftBorders[rightBorder] - i - 1, 0);
            numberOfIntersections += intt;
            if (numberOfIntersections > 10_000_000) {
                return -1;
            }
        }
        return numberOfIntersections;
    }
}
