package com.algorithms.chris.neetcode.trees;

/**
 * Проверить валидность бинарного дерева - все узлы слева должны быть меньше текущего узла, все узлы справа - больше.
 * Решение - рекурсия. При проверке левого поддерева обновлять правую границу - значение текущей ноды. Элемент слева не должен быть больше этой границы.
 * Минимальная граница остается той же.
 * При проверке правого поддерева обновлять левую границу - значение текущей ноды. Элемент справа не должен быть меньше этой границы.
 * Максимальная граница остается той же.
 * <p>
 * Check if binary tree is valid - all nodes on the left should be less than current node, all nodes on the right should be bigger.
 * Solution - recursion. When checking a left subtree pass min value = from previous call, maxValue = current node. While checking the right subtree pass min
 * value = current node, max value = from previous call.
 */
public class IsValidBST {

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val <= minVal || root.val >= maxVal) {
            return false;
        }
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
