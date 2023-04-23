package com.algorithms.chris.neetcode.trees;

import static java.lang.Math.max;

/**
 * Найти диаметр бинарного дерева (наибольшее расстояние между любыми двумя узлами).
 * Решение - для каждого узла подсчитывать высоту узла = max(left.height, right.height) + 1 и диаметр = left.height + right.height + 2.
 * Глобально хранить максимальный диаметр.
 * <p>
 * Find diameter of binary tree (the longest path between any two nodes).
 * Solution: - for each node calculate node's height = max(left.height, right.height) + 1 and diameter = left.height + right.height + 2.
 * Globally store max diameter.
 */
public class DiameterOfBinaryTree {

    private static int maxDiameter;

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        if (root == null) {
            return 0;
        }
        dfs(root);
        return maxDiameter;
    }

    private static int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        var leftHeight = dfs(node.left);
        var rightHeight = dfs(node.right);
        var height = max(leftHeight, rightHeight) + 1;
        var diameter = leftHeight + rightHeight + 2;
        if (diameter > maxDiameter) {
            maxDiameter = diameter;
        }
        return height;
    }

}
