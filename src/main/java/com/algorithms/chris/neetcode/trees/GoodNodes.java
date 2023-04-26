package com.algorithms.chris.neetcode.trees;

/**
 * Найди "хорошие узлы" дерева. Хорошие - если на пути от корня до X узла нет узлов, у которых значение больше X узла.
 * Решение - статический счетчик, рекурсия, передавать текущее максимальное значение на пути.
 * <p>
 * Find good nodes. Good ones - if the path from root to X node doesn't have values bigger than X node.
 * Solution - static counter, recursion, pass current max value on the path.
 */
public class GoodNodes {

    private static int count = 0;

    public static int goodNodes(TreeNode root) {
        count = 0;
        goodNodes(root, root);
        return count;
    }

    private static void goodNodes(TreeNode node, TreeNode maxVal) {
        if (node == null) {
            return;
        }
        if (node.val >= maxVal.val) {
            maxVal = node;
            count++;
        }
        goodNodes(node.left, maxVal);
        goodNodes(node.right, maxVal);
    }
}
