package com.algorithms.chris.neetcode.heap_priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Добавляются цифры, иногда нужно искать медиану.
 * Решение: бинарный поиск при вставке.
 * Побыстрее решение: две priority queue. Одна содержит первую половину, вторая вторую. При добавлении числа проверять, нужно ли сбалансировать очереди.
 * Если разница между ними больше, чем 1, переместить число в меньшую по размеру очередь.
 * <p>
 * Numbers are added, sometimes there is a need to find median.
 * Solution: binary search when inserting.
 * Faster solution: Two priority queues. One contains the first half, the second one a larger half. When adding a number, check if should balance queues.
 * If the size difference is more than 1, move elements to a smaller queue.
 */
class MedianFinder {

    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;

    public MedianFinder() {
        minheap = new PriorityQueue<>(Collections.reverseOrder());
        maxheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (minheap.isEmpty() || num <= minheap.peek()) {
            minheap.add(num);
        } else {
            maxheap.add(num);
        }
        balanceHeaps();
    }

    public double findMedian() {
        int minheapsize = minheap.size();
        int maxheapsize = maxheap.size();
        if (minheapsize == maxheapsize) {
            return (maxheap.peek() + minheap.peek()) / 2.0;
        }
        return minheapsize > maxheapsize ? (double) minheap.peek() : (double) maxheap.peek();
    }

    private void balanceHeaps() {
        int minheapsize = minheap.size();
        int maxheapsize = maxheap.size();
        if (minheapsize - maxheapsize > 1) {
            maxheap.add(minheap.poll());
        } else if (maxheapsize - minheapsize > 1) {
            minheap.add(maxheap.poll());
        }
    }
}