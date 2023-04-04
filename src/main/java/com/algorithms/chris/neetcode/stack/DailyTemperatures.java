package com.algorithms.chris.neetcode.stack;

import java.util.LinkedList;

/**
 * Дан массив чисел, которые представляют собой дневные температуры. Верните массив чисел, которые обозначают, сколько дней нужно ждать перед
 * наступлением более высокой температуры. Если теплого дня больше не будет, в массиве должен быть 0 для этого дня.
 * Решение:
 * Держать стэк со всеми пройденными до i температурами.
 * Пройтись по температурам. Для каждого значения из стэка, которое меньше текущей температуры, проставить количество дней.
 * <p>
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
 * is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * Solution:
 * Have a stack with all temperatures accumulated before.
 * Iterate through temperatures. For each value in stack, which is less than current temperature, set the amount of days.
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (stack.peekFirst() != null && temperatures[stack.peekFirst()] < temperatures[i]) {
                result[stack.peekFirst()] = i - stack.removeFirst();
            }
            stack.addFirst(i);
        }
        return result;
    }
}
