package com.algorithms.chris.neetcode.trees;

/**
 * Найти максимальную сумму на любой path дерева.
 * Решение - рекурсия.
 * 1) Для каждого узла вычислить максимум слева, максимум справа.
 * 2) Посчитать возможный максимум на path - root + left + right, root, root + left, root + right.
 * 3) Обновить максимум, если нужно.
 * 4) Вернуть наверх результат root + left + right нельзя, потому что это уже будет не path. Нужно вернуть max (root + left, root + right, root).
 * <p>
 * Find maximum sum on any path of the tree
 * Solution - recursion.
 * 1) For each node count max of left subtree, max of right subtree.
 * 2) Count possible maximum on path = root + left + right, root, root + left, root + right.
 * 3) Save maximum, if needed.
 * 4) Return to the root max result on path without splitting, because with splitting is not considered a path. Return max (root + left, root + right, root).
 */
public class MaxPathSum {

    static int maxPath;

    public static int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        maxPathSumOnNode(root);
        return maxPath;
    }

    private static int maxPathSumOnNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var maxLeft = maxPathSumOnNode(root.left);
        var maxRight = maxPathSumOnNode(root.right);
        int maxPathWithoutSplitting = Math.max(Math.max(maxLeft + root.val, maxRight + root.val), root.val);
        int maxPathWithSplitting = Math.max(maxPathWithoutSplitting, maxLeft + root.val + maxRight);
        if (maxPathWithSplitting > maxPath) {
            maxPath = maxPathWithSplitting;
        }
        return maxPathWithoutSplitting;
    }
}
