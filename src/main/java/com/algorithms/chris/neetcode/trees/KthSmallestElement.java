package com.algorithms.chris.neetcode.trees;

import java.util.LinkedList;

/**
 * Нужно найти k значение по возрастанию.
 * Решение 1: Рекурсия
 * Пойти налево. Инкрементить count. Есть достигли k, засчитать текущий узел как результат. Пойти направо.
 * Решение 2: Итеративный поиск в ширину.
 * 1) Добавить все левые узлы, пока не кончатся.
 * 2) Взять первый с начала.
 * 3) Если count == k, нашли результат.
 * 4) Переместиться на узел справа. Идти к 1)
 * <p>
 * Find k-th value in ascending order.
 * Solution 1: Recursion
 * Go left. Increment count. If reached k, save current value as a result. Go right.
 * Solution 2: Iterative breadth first.
 * 1) Add left nodes, while present.
 * 2) Remove first node from the head.
 * 3) If count == k, we found the result.
 * 4) Go to the right node. Go to 1)
 */
public class KthSmallestElement {

    private static int count = 0;
    private static int val = -1;

    public static int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> st = new LinkedList<>();
        TreeNode currentSubtree = root;
        int count = 0;

        while (!st.isEmpty() || currentSubtree != null) {
            if (currentSubtree != null) {
                st.addFirst(currentSubtree);
                currentSubtree = currentSubtree.left;
            } else {
                var node = st.removeFirst();
                if (++count == k) {
                    return node.val;
                }
                currentSubtree = node.right;
            }
        }
        return 0;
    }

    public static int kthSmallest2(TreeNode root, int k) {
        count = 0;
        val = -1;
        kthSmallestRecursive(root, k);
        return val;
    }

    public static void kthSmallestRecursive(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        kthSmallestRecursive(root.left, k);
        count++;
        if (count == k) {
            val = root.val;
            return;
        }
        kthSmallestRecursive(root.right, k);
    }
}
