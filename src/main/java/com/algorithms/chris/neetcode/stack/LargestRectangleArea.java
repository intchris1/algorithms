package com.algorithms.chris.neetcode.stack;

import java.util.LinkedList;

import static java.lang.Math.max;

/**
 * Дан массив с числами, обозначающими высоту колонок в гистограмме.
 * Нужно найти площадь самого большого прямоугольника.
 * Решение:
 * 1) Завести стэк, в котором будут лежать: индекс начала прямоугольника, высота.
 * 2) Для каждой высоты:
 * 2.1) Проверить каждое из лежащих в стеке значений.
 * Если число больше, чем текущая высота, значит, начало прямоугольника находится раньше.
 * 2.2) Можно удалить предыдущее значение из стека, потому что этот прямоугольник точно не может быть продлен.
 * Перед этим посчитать его площадь, обновить максимальное значение, если нужно.
 * 2.3) Обновить предполагаемое начало текущего прямоугольника - индекс в только что удаленном значении.
 * 2.4) Добавить новое значение в стек.
 * 3) Пройтись по оставшимся в стеке элементам. Для каждого элемента конец прямоугольника в конце массива.
 * Посмотреть, если там есть максимальная площадь.
 * <p>
 * An array of integers is given, each number is a height of a column in a histogram.
 * Find the area of the largest rectangle in the histogram.
 * Solution:
 * 1) Create a stack, containing pairs of index of each rectangle beginning and its height.
 * 2) For each height:
 * 2.1) Check each pair in the tail of the stack.
 * If the height of a pair is greater than current height, it means that the beginning of current rectangle was earlier.
 * 2.2) Current pair can be deleted from stack, because it means that this rectangle cannot be extended.
 * Calculate its area before deletion, check if it's greater than maxArea.
 * 2.3) Update supposed beginning of the current rectangle - it's an index from just deleted pair.
 * 2.4) If there is no values with height greater that current, add a new pair to stack.
 * 3) For each remaining pair - the ending of every rectangle is at the end of an array. Check if there is an area greater than max.
 */
public class LargestRectangleArea {

    public static int largestRectangleArea(int[] heights) {
        LinkedList<int[]> stack = new LinkedList<>();
        int maxHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (stack.peekLast() != null && stack.peekLast()[1] > heights[i]) {
                int[] toBeDeleted = stack.removeLast();
                int areaOfToBeDeleted = (i - toBeDeleted[0]) * toBeDeleted[1];
                maxHeight = max(areaOfToBeDeleted, maxHeight);
                start = toBeDeleted[0];
            }
            stack.add(new int[]{start, heights[i]});
        }
        while (stack.peekLast() != null) {
            int[] elem = stack.removeLast();
            int area = (heights.length - elem[0]) * elem[1];
            maxHeight = max(area, maxHeight);
        }
        return maxHeight;
    }
}
