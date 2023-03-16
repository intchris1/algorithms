package com.algorithms.chris.neetcode.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Найти все комбинации из трех элементов, которые в сумме дают 0.
 * Решение - алгоритм two pointers
 * <p>
 * Find all triplets such that add up to 0.
 * Solution - two pointers algorithm
 * //пробнй коммит
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //учитывать, что не должно быть дупликата у левого индекса
            //подсчитываем сумму по схеме TwoSumSorted
            int middleIndex = i + 1;
            int rightIndex = nums.length - 1;
            while (middleIndex < rightIndex) {
                int threeSum = nums[i] + nums[middleIndex] + nums[rightIndex];
                if (threeSum < 0) {
                    middleIndex++;
                } else if (threeSum > 0) {
                    rightIndex--;
                } else {
                    triplets.add(List.of(nums[i], nums[middleIndex], nums[rightIndex]));
                    middleIndex++;
                    //Обновляем только средний индекс, отслеживая дубликаты.
                    //Дублируемость правого индекса будет устраняться сама собой при подсчете суммы
                    while (nums[middleIndex] == nums[middleIndex - 1] && middleIndex < rightIndex) {
                        middleIndex++;
                    }
                }
            }
        }
        return triplets;
    }
}

