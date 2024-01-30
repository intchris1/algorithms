package com.algorithms.chris.neetcode.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * Нужно вернуть все возможные подсписки для данного списка чисел.
 * Решение:
 * Отсортировать.
 * Для каждого подсписка проходиться по оставшимся впереди числам. Добавлять каждое число, которое не равно предыдущему.
 * Получившийся подсписок опять прогонять с оставшимися впереди числами (рекурсия).
 * <p>
 * Sort.
 * Return a list of all possible subsets for a given array.
 * Solution: for each subset iterate over numbers ahead of it. Add each number that is not equal to the previous one.
 * And use this subset to go over the numbers ahead of it (recursion).
 */
public class Subsets2 {

    public static List<List<Integer>> subsets2(int[] nums) {
        Arrays.sort(nums);
        var result = new LinkedList<List<Integer>>();
        result.add(emptyList());
        for (int i = 0; i < nums.length; i++) {
            var current = nums[i];
            if (i > 0 && nums[i - 1] == current) {
                continue;
            }
            var initialList = new LinkedList<Integer>();
            initialList.add(current);
            result.add(initialList);
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                processSubset(result, initialList, nums, j);
            }
        }
        return result;
    }

    private static void processSubset(LinkedList<List<Integer>> result, LinkedList<Integer> currentList, int[] nums, int j) {
        if (j == nums.length) {
            return;
        }
        var oneMore = new LinkedList<>(currentList);
        oneMore.add(nums[j]);
        result.add(oneMore);
        for (int i = j + 1; i < nums.length; i++) {
            if (i > j + 1 && nums[i - 1] == nums[i]) {
                continue;
            }
            processSubset(result, oneMore, nums, i);
        }
    }
}

