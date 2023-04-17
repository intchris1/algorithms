package com.algorithms.chris.neetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Инвертировать бинарное дерево.
 * Решение - рекурсия или стек.
 * <p>
 * Invert binary tree.
 * Solution - recursion or stack.
 */
public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        var left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }

    public static TreeNode invertTreeStack(TreeNode root) {
        if (root == null) {
            return null;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
