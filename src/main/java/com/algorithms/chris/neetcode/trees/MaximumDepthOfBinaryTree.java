package com.algorithms.chris.neetcode.trees;

import java.util.LinkedList;

/**
 * Найти максимальную глубину бинарного дерева.
 * Решения:
 * 1) Рекурсия. 1 + max(search(root.left), search(root.right))
 * 2) Поиск в ширину. На каждом уровне удалять все текущие ноды из стэка, попутно добавляя их детей в стэк.
 * 3) Поиск в глубину итеративный. Хранить уровень ноды. Удалять с конца узел, добавлять детей в стэк, увеличивая их уровень, пока не кончатся.
 * <p>
 * Find maximum depth of binary tree.
 * Solutions:
 * 1) Recursion. 1 + max(search(root.left), search(root.right))
 * 2) Breadth search. On each level remove all current nodes from stack, adding their children to the tail.
 * 3) Depth search iterative. Keep current node level. Remove one node from bottom, add it's children and increment their level.
 */
public class MaximumDepthOfBinaryTree {

    public static int maxDepthDepthFirstSearch(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Integer.max(maxDepthDepthFirstSearch(root.left), maxDepthDepthFirstSearch(root.right));
    }

    public static int maxDepthBreadthFirstSearch(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        var count = 0;
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var node = queue.removeFirst();
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            count++;
        }
        return count;
    }

    public static int maxDepthBreadthFirstIterativeSearch(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var queue = new LinkedList<NodeWithLevel>();
        queue.addLast(new NodeWithLevel(root, 1));
        int maxLevel = 1;
        while (!queue.isEmpty()) {
            var removed = queue.removeLast();
            if (removed.node.left != null) {
                queue.addLast(new NodeWithLevel(removed.node.left, removed.level + 1));
            }
            if (removed.node.right != null) {
                queue.addLast(new NodeWithLevel(removed.node.right, removed.level + 1));
            }
            maxLevel = Integer.max(removed.level, maxLevel);
        }
        return maxLevel;
    }

    static class NodeWithLevel {
        TreeNode node;
        int level;

        public NodeWithLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

}
