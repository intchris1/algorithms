package com.algorithms.chris.codility.stack_and_queues;

import java.util.ArrayDeque;

/**
 * Дано два массива, описывающих рыб.
 * Все рыбы находятся друг за другом по реке, позиция = индекс в массиве.
 * Первый массив описывает размер рыбы, второй массив описывает направление, куда плывет рыба, вверх или вниз.
 * Если две рыбы встречаются, та, что больше, них съедает другую.
 * Нужно найти, сколько рыб останутся живы.
 * <p>
 * Алгоритм - вести стэк с рыбами, двигающимися вниз.
 * Для каждой рыбы:
 * Если рыба движется вниз, добавить в стек
 * Иначе:
 * 1) Проверить последнюю двигающуюся вниз рыбу. Если она не нулл, одна из рыб будет точно съедена, прибавляем каунтер.
 * Проверяем, какая именно будет съедена. Если та, что двигается вниз - удаляем ее из стека, вернуться в пункт 1)
 */
public class Fish {

    public static int solution(int[] A, int[] B) {
        ArrayDeque<Integer> fishMovingDown = new ArrayDeque<>();
        int fishEaten = 0;
        for (int i = 0; i < A.length; i++) {
            int fishDir = B[i];
            int fishSize = A[i];
            if (fishDir == 1) {
                fishMovingDown.push(fishSize);
            } else {
                Integer huntingFishSize;
                while ((huntingFishSize = fishMovingDown.peek()) != null) {
                    fishEaten++;
                    if (huntingFishSize < fishSize) {
                        fishMovingDown.poll();
                    } else {
                        break;
                    }
                }
            }
        }
        return A.length - fishEaten;
    }


}
