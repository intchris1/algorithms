package com.algorithms.chris.neetcode.heap_priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Дан массив координат (х, у). Нужно вернуть K ближайших точек от центра.
 * Решение - складывать в PriorityQueue, поддерживать ее размер как K.
 * <p>
 * Given an array with points (x, y). Return an array of k closest points from the origin (0, 0).
 * Solution - keep a PriorityQueue of size k.
 */
public class KClosestPointsToOrigin {

    public static int[][] kClosest(int[][] points, int k) {
        Comparator<PointIndexWithDistance> comparator = Comparator.comparingDouble((PointIndexWithDistance it) -> it.distance).reversed();
        var queue = new PriorityQueue<>(comparator);
        for (int i = 0; i < points.length; i++) {
            var point = points[i];
            var x = point[0];
            var y = point[1];
            var distance = Math.sqrt(x * x + y * y);
            queue.add(new PointIndexWithDistance(i, distance));
            if (queue.size() > k) {
                queue.remove();
            }
        }
        var result = new int[k][];
        for (int i = 0; i < result.length; i++) {
            var removed = queue.remove();
            result[i] = points[removed.index];
        }
        return result;
    }

    private static class PointIndexWithDistance {
        final int index;
        final double distance;

        PointIndexWithDistance(int index, double distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
