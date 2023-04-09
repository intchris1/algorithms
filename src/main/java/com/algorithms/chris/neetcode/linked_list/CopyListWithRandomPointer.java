package com.algorithms.chris.neetcode.linked_list;

import java.util.HashMap;

/**
 * Дан связный список длиной n, в каждом узле содержится указатель на рандомный узел или на null.
 * Нужно сделать глубокую копию этого списка.
 * Решение: хранить копию каждого элемента в мапе, доставать next/random по ссылке.
 * <p>
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 * Construct deep copy of a list.
 * Solution: store every node copy in a map, get next/random elements by reference.
 */
public class CopyListWithRandomPointer {

    public static Node copyRandomList(Node head) {
        var map = new HashMap<Node, Node>();
        var current = head;
        while (current != null) {
            var copy = map.get(current);
            if (copy == null) {
                copy = new Node(current.val);
                map.put(current, copy);
            }
            if (copy.next == null && current.next != null) {
                var copyNext = map.get(current.next);
                if (copyNext == null) {
                    copyNext = new Node(current.next.val);
                    map.put(current.next, copyNext);
                }
                copy.next = copyNext;
            }
            if (copy.random == null && current.random != null) {
                var random = current.random;
                var copyRandom = map.get(random);
                if (copyRandom == null) {
                    copyRandom = new Node(random.val);
                    map.put(random, copyRandom);
                }
                copy.random = copyRandom;
            }
            current = current.next;
        }
        return map.get(head);
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
