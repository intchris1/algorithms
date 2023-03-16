package com.algorithms.chris.neetcode.two_pointers;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Найти максимальную площадь контейнера с водой.
 * Площадь считается как наименьший из двух элементов в квадрате * расстояние между двумя элементами
 * Решение - алгоритм two pointers. Сдвигать левый указатель, если элемент меньше или равен правому.
 * Сдвигать правый указатель, если правый элемент меньше левого.
 * <p>
 * Find maximum square of a water container.
 * Square of a container is the lease of two elements squares * distance between elements
 * Solution - two pointers algorithm. Shift left index, if an element is less or equal to the right element.
 * Shift right index, if an element is less than the left element.
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int maxSquare = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        while (leftIndex < rightIndex) {
            int currentSquare = (rightIndex - leftIndex) * min(height[leftIndex], height[rightIndex]);
            maxSquare = max(maxSquare, currentSquare);
            if (height[leftIndex] <= height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return maxSquare;
    }
}
