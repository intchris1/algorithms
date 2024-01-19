package com.algorithms.chris.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Нужно вернуть список из всех возможных перестановок.
 * Решение:
 * 1. Начать с пустого списка.
 * 2. Пройтись по всем номерам. Если текущий список не содержит номер, добавить.
 * 3. Перейти в пункт 1. с этим списком (пока не кончатся все номера).
 * 4. Если размер списка - число элементов, мы нашли перестановку. Добавить копию этого списка в результат.
 * 5. После выхода из рекурсии нужно удалить текущий номер из списка для нахождения перестановок.
 * <p>
 * Return a list of all possible permutations.
 * Solution:
 * Recursion.
 * 1. Start with empty list.
 * 2. Iterate over numbers. If current list doesn't contain this number, add.
 * 3. Go to 1 (until all numbers finished).
 * 4. If list's size equals number of input elements, we found a permutation. Add copy of this list to result.
 * 5. After recursion delete current number from the list.
 */
public class Permutation {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        permute(curr, ans, nums);
        return ans;
    }

    private static void permute(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
        } else {
            for (Integer num : nums) {
                if (!curr.contains(num)) {
                    curr.add(num);
                    permute(curr, ans, nums);
                    curr.remove(num);
                }
            }
        }
    }
}

