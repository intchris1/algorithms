package com.algorithms.chris.neetcode.heap_priority_queue;

import java.util.PriorityQueue;

/**
 * Нужно возвращать k наибольший по порядку с конца элемент каждый раз при добавлении нового элемента.
 * Решение:
 * 1) Использовать priority queue.
 * 2) Все время держать ее так, чтобы голова хранила нужный элемент:
 * - при создании убрать с головы, пока не останется k элементов
 * - при добавлении проверять - если размер превысил k, удалить с головы
 * <p>
 * Return kth largest element each time after adding a new number.
 * Solution:
 * 1) Use priority queue.
 * 2) Keep it the way that the head stores kth largest element:
 * - After creation remove from the head, until you have k elements
 * - Each time after adding check if the queue is bigger than k, in this case remove from head
 */
public class KthLargest {

    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
        }
        while (heap.size() > k) {
            heap.poll();
        }
        this.k = k;
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.element();
    }
}
