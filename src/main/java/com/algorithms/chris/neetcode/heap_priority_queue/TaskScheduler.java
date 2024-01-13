package com.algorithms.chris.neetcode.heap_priority_queue;

import java.util.Arrays;

/**
 * Дан массив заданий, которые могут быть выполнены в любом порядке за одну единицу времени.
 * Между одинаковыми заданиями должен пройти обязательный период времени n.
 * Вернуть наименьшее количество времени для выполнения всех заданий.
 * <p>
 * Решение:
 * 1) Посчитать количество заданий для каждой буквы. Отсортировать.
 * 2) Найти наибольшее количество для одинакового задания.
 * 3) Вычислить максимальное время для простаивания - (цифра из п.2 - 1) * n.
 * 4) Пройтись по массиву в обратном порядке, вычитать из времени простаивания каждый элемент.
 * Если элемент равен числу из п.2, это значит, что одно задание не будет занимать время простаивания, а добавится уже в конце. Тогда нужно добавить обратно 1.
 * 5) Сложить количество всех заданий и время простаивания. Если время простаивания отрицательное, ничего не добавлять.
 * <p>
 * Given a characters array tasks. Tasks could be done in any order. Each task is done in one unit of time.
 * There is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array).
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 * Solution:
 * 1) Count frequency of each letter. Sort.
 * 2) Find maximum frequency.
 * 3) Find maximum idle time - (p.2 - 1) * n.
 * 4) Iterate the array in reverse order starting from the element before last. Subtract each element from maximum idle time.
 * If an element equals max frequency from 2), it means that one task will not be done during idle time, it will be added in the end.
 * In this case we subtract its frequency but add back one.
 * 5) Add length of the initial array and remaining idle time. If the idle time is negative, add nothing.
 */
public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        int[] frequences = new int[26];
        for (char task : tasks) {
            frequences[task - 'A']++;
        }
        Arrays.sort(frequences);
        int maxFrequency = frequences[25];
        int maxIdleTime = (maxFrequency - 1) * n;
        for (int i = 24; i >= 0; i--) {
            int current = frequences[i];
            maxIdleTime -= current;
            if (current == maxFrequency) {
                maxIdleTime += 1;
            }
        }
        return tasks.length + Math.max(0, maxIdleTime);
    }

}
