package com.algorithms.chris.neetcode.binary_search;

/**
 * Дан массив чисел, сортированный по возрастанию. Нужно найти заданное число и вернуть его индекс, если такого числа нет - вернуть -1.
 * <p>
 * Решение:
 * 1) Проверить: если число больше первого элемента в ряду и меньше последнего элемента в ряду, проверить каждый элемент в этом ряду.
 * 2) Если число равно первому элементу в ряду, найдено.
 * 3) Если число равно последнему элементу в ряду, найдено.
 * 4) Если число меньше первого элемента в ряду, вернуть false.
 * 5) Иначе продолжить.
 * <p>
 * An array of integers is given, which is sorted in ascending order. Find target number and return its index, if there is no such number - return -1.
 * Solution:
 * 1) If target is greater than the first element in a row and less than the last element in a row, check all elements in a row.
 * 2) If target is equal to the first number in a row, return true.
 * 3) If target is equal to the last number in a row, return true.
 * 4) If target is less then the first number in a row, return false.
 * 5) Else continue.
 */
public class SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        for (int[] ints : matrix) {
            var first = ints[0];
            var last = ints[n - 1];
            if (target > first && target < last) {
                for (int j = 1; j < n; j++) {
                    if (target == ints[j]) {
                        return true;
                    }
                }
            } else if (target == first) {
                return true;
            } else if (target == last) {
                return true;
            } else if (target < first) {
                return false;
            }
        }
        return false;
    }
}

