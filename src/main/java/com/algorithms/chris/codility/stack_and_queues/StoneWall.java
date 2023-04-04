package com.algorithms.chris.codility.stack_and_queues;

import java.util.LinkedList;

/**
 * Каменная стена - нужно посчитать минимальное количество монолитных прямоугольных блоков, их которых можно построить стену с такой высотой.
 * i = высота
 * Новый блок гарантированно начинается, если:
 * 1) текущая высота меньше предыдущей
 * 2) в числах слева нет числа, равного текущей высоте, или такое число есть, но между этими числами есть числа меньше, которые прерывают блок.
 * Нужно вести учет всем блокам, которые потенциально еще могут включить какое-то число.
 * <p>
 * Для каждого числа:
 * 1. Удалить из стека все числа меньше, чем текущее, так как эти блоки гарантированно кончились.
 * 2. Если последнее оставшееся число равно текущему, ничего не делать - данное число не новый блок.
 * 3. Иначе посчитать как новый блок и добавить в стек.
 * <p>
 * Stone wall - calculate the minimum number of monolithic rectangular blocks, from which you can build a wall with given heights.
 * i = height
 * A new block is guaranteed to start if:
 * 1) the current height is less than the previous one
 * 2) on the left there is no number equal to the current height, or there is such a number but between these numbers there are smaller numbers that break the block.
 * Keep a record of all the blocks that could potentially still include some number.
 * <p>
 * For each number:
 * 1. Remove all numbers less than the current one from the stack, since these blocks are guaranteed to break.
 * 2. If the last remaining number is equal to the current one, do nothing - this number is not a new block.
 * 3. Otherwise, count as a new block and add to the stack.
 */
public class StoneWall {

    public static int solution(int[] H) {
        var stack = new LinkedList<Integer>();
        int blocksCount = 0;
        for (int height : H) {
            while (!stack.isEmpty() && stack.peekFirst() > height) {
                stack.removeFirst();
            }
            var lastAdded = stack.peekFirst();
            if (lastAdded == null || lastAdded < height) {
                blocksCount++;
                stack.push(height);
            }
        }
        return blocksCount;
    }
}
