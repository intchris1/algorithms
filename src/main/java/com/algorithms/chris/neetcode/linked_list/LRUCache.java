package com.algorithms.chris.neetcode.linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * Сделать Least Recently Used Cache.
 * Если кэш превышает допустимый размер, удалить элемент, который больше всех не использовался.
 * Использовать double linked list, хранить значения головы и хвоста, сами узлы хранить в мапе.
 * <p>
 * Make Least Recently Used Cache.
 * If the cache exceeds capacity, remove least recently used element.
 * Use double linked list, store head and tail values, store nodes in a map.
 */
public class LRUCache {

    private final int capacity;
    private final Map<Integer, DoubleNode> map = new HashMap<>();
    private DoubleNode head = null;
    private DoubleNode tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public Integer get(int key) {
        var result = map.get(key);
        if (result != null) {
            moveToHead(result);
            return result.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        var current = map.get(key);
        if (current != null) {
            current.val = value;
            moveToHead(current);
        } else {
            var node = new DoubleNode(key, value);
            if (tail == null) {
                tail = node;
            }
            addNewHead(node);
            map.put(key, node);
            if (map.values().size() > capacity) {
                removeLast();
            }
        }
    }

    private void removeLast() {
        var removed = map.remove(tail.key);
        removed.next.prev = null;
        tail = removed.next;
    }

    private void moveToHead(DoubleNode result) {
        //make it head
        if (result.prev != null && result.next != null) { //in the middle
            //detach
            result.prev.next = result.next;
            result.next.prev = result.prev;
            //attach
            head.next = result;
            result.prev = head;
        } else if (result == tail && result != head) {//in the end
            //attach only
            head.next = result;
            result.prev = head;
            //update tail
            tail = result.next;
            result.next.prev = null;
        }
        result.next = null;
        head = result;
    }

    private void addNewHead(DoubleNode node) {
        if (head != null) {
            head.next = node;
            node.prev = head;
        }
        head = node;
    }

    public static class DoubleNode {
        public int key;
        public int val;
        public DoubleNode next;
        public DoubleNode prev;

        public DoubleNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
