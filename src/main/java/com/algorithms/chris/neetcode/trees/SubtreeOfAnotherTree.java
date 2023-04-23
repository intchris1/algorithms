package com.algorithms.chris.neetcode.trees;

/**
 * Проверить, является ли второе дерево поддеревом первого.
 * <p>
 * Check if the second tree is a subtree of the first one.
 */
public class SubtreeOfAnotherTree {

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return (root.val == subRoot.val && isSameTree(root, subRoot)) || (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.val == q.val && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
        }
    }

}
