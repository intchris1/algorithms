package com.algorithms.chris.neetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Взять ряд узлов, который был бы виден, если бы мы стояли справа и смотрели на дерево.
 * Решение 1:
 * Обычный поиск в ширину с помощью очереди.
 * Решение 2:
 * Рекурсия. Сначала пройтись по всем правым узлам, инкрементируя их глубину. Потом пройтись по линии чуть левее, и т.д.
 * <p>
 * Return list of nodes, that would be seen if we stood on the right and looked at the tree.
 * Solution 1:
 * Breadth first search with queue.
 * Solution 2:
 * Recursion. First go through all nodes on the right, incrementing their depth. Then go through the line a bit on the left, and so on.
 */
public class RightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            result.add(queue.getLast().val);
            var length = queue.size();
            for (int i = 0; i < length; i++) {
                var removed = queue.removeFirst();
                if (removed.left != null) {
                    queue.addLast(removed.left);
                }
                if (removed.right != null) {
                    queue.addLast(removed.right);
                }
            }
        }
        return result;
    }

    public static List<Integer> rightSideViewRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightSideViewRecursive(root, list, 0);
        return list;
    }

    private static void rightSideViewRecursive(TreeNode node, List<Integer> list, int depth) {
        if (node != null) {
            if (depth == list.size()) {
                list.add(node.val);
            }
            rightSideViewRecursive(node.right, list, depth + 1);
            rightSideViewRecursive(node.left, list, depth + 1);
        }
    }
}
