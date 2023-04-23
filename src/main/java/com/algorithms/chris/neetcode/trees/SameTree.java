package com.algorithms.chris.neetcode.trees;

/**
 * Проверить, одинаковые ли деревья.
 * <p>
 * Check if two binary trees are the same.
 */
public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.val == q.val && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
        }
    }
}
