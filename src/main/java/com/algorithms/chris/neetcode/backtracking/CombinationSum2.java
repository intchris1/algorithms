package com.algorithms.chris.neetcode.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Нужно вернуть список из всех списков с числами, которые в сумме дают целевую сумму.
 * Исходный список содержит только уникальные числа.
 * В результирующих списках число не должно повторяться.
 * Решение - сортировка, рекурсия, пройтись по каждому числу, добавлять следующее число в список (если оно не равно предыдущему!) и итерировать по оставшимся числам впереди.
 * <p>
 * Return a list of lists with numbers, that sum up to target. Input array contains only unique numbers.
 * Result list can contain any number duplicated. Permutations are not allowed.
 * Solution - sort, recursion. Iterate each number, add the next number if it's not equal to the previous one
 * and iterate over the rest of the numbers ahead.
 */
public class CombinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        var result = new LinkedList<List<Integer>>();
        for (int i = 0; i < candidates.length; i++) {
            if (i > 0 && candidates[i - 1] == candidates[i]) {
                continue;
            }
            var initialList = new LinkedList<Integer>();
            processSubset(result, initialList, i, candidates, 0, target);
        }
        return result;
    }

    private static void processSubset(List<List<Integer>> result, LinkedList<Integer> withoutCurrent,
                                      int i, int[] candidates, int currentSum, int target) {
        if (i == candidates.length) {
            return;
        }
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
        for (int j = i + 1; j < candidates.length; j++) {
            if (j > i + 1 && candidates[j - 1] == candidates[j]) {
                continue;
            }
            processSubset(result, newWithAdded, j, candidates, currentSumWithAdded, target);
        }
    }
}

