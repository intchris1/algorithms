package com.algorithms.chris.neetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Нужно вернуть список из всех списков с числами, которые в сумме дают целевую сумму. Исходный список содержит только уникальные числа.
 * В результирующих списках число может повторяться сколько угодно раз. Перестановки не разрешаются.
 * Решение - рекурсия, пройтись по каждому числу, добавлять текущее число в список еще раз и итерировать по оставшимся числам впереди.
 * 2, 22, 222, 2222, 2223, 2226, 2227
 * <p>
 * Return a list of lists with numbers, that sum up to target. Input array contains only unique numbers.
 * Result list can contain any number duplicated. Permutations are not allowed.
 * Solution - recursion. Iterate each number, add current number one more time and iterate over the rest of the numbers ahead.
 * 2, 22, 222, 2222, 2223, 2226, 2227
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        var result = new LinkedList<List<Integer>>();
        for (int i = 0; i < candidates.length; i++) {
            var initialList = new LinkedList<Integer>();
            processSubset(result, initialList, i, candidates, 0, target);
        }
        return result;
    }

    private static void processSubset(List<List<Integer>> result, LinkedList<Integer> withoutCurrent,
                                      int i, int[] candidates, int currentSum, int target) {
        var current = candidates[i];
        var newWithAdded = new LinkedList<>(withoutCurrent);
        newWithAdded.add(current);
        var currentSumWithAdded = currentSum + current;
        if (currentSumWithAdded == target) {
            result.add(newWithAdded);
            return;
        } else if (currentSumWithAdded > target) {
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            processSubset(result, newWithAdded, j, candidates, currentSumWithAdded, target);
        }
    }
}

