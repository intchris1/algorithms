package com.algorithms.chris.neetcode.heap_priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Дан массив камней. Берут два самых тяжелых камня и бьют друг об друга, после этого у того, что тяжелее, уменьшается вес в размере веса другого камня,
 * тот камень, что легче, уничтожается. Нужно вернуть вес последнего оставшегося камня. Или ноль.
 * Решение - PriorityQueue.
 * <p>
 * Given an array of stones. Two heaviest stones are taken and beaten up against each other.
 * After that, the heavier one loses weight in the amount of the other stone's weight, the lighter one is destroyed.
 * Return the weight of the last stone alive. Or zero.
 */
public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        var queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.peek() != null) {
            var heavy1 = queue.remove();
            if (queue.peek() != null) {
                var heavy2 = queue.remove();
                if (heavy1 > heavy2) {
                    heavy1 -= heavy2;
                    queue.add(heavy1);
                } else if (heavy1 < heavy2) {
                    heavy2 -= heavy1;
                    queue.add(heavy2);
                }
            } else {
                return heavy1;
            }
        }
        return 0;
    }
}
