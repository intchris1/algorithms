package com.algorithms.chris.neetcode.stack;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Сделайте стэк, который поддерживает операции push, pop, top, getMin за константное время.
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */
public class MinStack {
    private final ArrayDeque<Integer> deque;
    private final LinkedList<Integer> mins = new LinkedList<>();

    public MinStack() {
        deque = new ArrayDeque<>();
    }

    public void push(int val) {
        deque.push(val);
        if (mins.isEmpty() || mins.peekLast() >= val) {
            mins.add(val);
        }
    }

    public void pop() {
        var pop = deque.pop();
        if (Objects.equals(mins.peekLast(), pop)) {
            mins.removeLast();
        }
    }

    public int top() {
        return deque.peekFirst();
    }

    public int getMin() {
        return mins.peekLast();
    }
}
