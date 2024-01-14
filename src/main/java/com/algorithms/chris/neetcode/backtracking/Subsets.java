package com.algorithms.chris.neetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * Нужно вернуть все возможные подсписки для данного списка чисел.
 * Решение:
 * Для каждого подсписка проходиться по оставшимся впереди числам. Добавлять каждое число. Получившийся подсписок опять прогонять с оставшимися впереи числами (рекурсия).
 * <p>
 * Return a list of all possible subsets for a given array.
 * Solution: for each subset iterate over numbers ahead of it. Add each number. And use this subset to go over the numbers ahead of it (recursion).
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        var result = new LinkedList<List<Integer>>();
        result.add(emptyList());
        for (int i = 0; i < nums.length; i++) {
            var current = nums[i];
            var initialList = new LinkedList<Integer>();
            initialList.add(current);
            result.add(initialList);
            for (int j = i + 1; j < nums.length; j++) {
                processSubset(result, initialList, nums, j);
            }
        }
        return result;
    }

    private static void processSubset(LinkedList<List<Integer>> result, List<Integer> currentList, int[] nums, int j) {
        if (j == nums.length) {
            return;
        }
        var oneMore = new LinkedList<>(currentList);
        oneMore.add(nums[j]);
        result.add(oneMore);
        for (int i = j + 1; i < nums.length; i++) {
            processSubset(result, oneMore, nums, i);
        }
    }
}

