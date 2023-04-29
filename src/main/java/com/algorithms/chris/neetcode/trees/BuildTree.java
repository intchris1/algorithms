package com.algorithms.chris.neetcode.trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Нужно построить дерево на основе двух массивов - preOrder, inOrder. В preOrder сначала идет корень, потом левое поддерево, потомо правое.
 * В inOrder сначала левое поддерево, потом корень, потом правое поддерево.
 * 1) Сформировать мапу из массива inOrder, чтобы можно было находить индекс элементв в inOrder массиве.
 * 2) Рекурсивно формировать узлы.
 * 2.1) При каждой итерации инкрементировать индекс - мы идем по массиву preOrder по порядку.
 * 2.2) Для формирования левого передать начало - 0, конец - индекс элемента в inOrder - 1.
 * 2.3) Если start > end, узла нет.
 * 2.4) Для формирования правого начало - индекс элемента в inOrder + 1, конец - длина массива inOrder - 1.
 * <p>
 * Build tree from two arrays - preOrder, inOrder. In preOrder array first comes the root, then goes left subtree, then right.
 * InOrder array - left subtree, root node, right subtree.
 * 1) Create a hashmap from inOrder array, so that you can find an index of the element in inOrder array.
 * 2) Recursively form nodes.
 * 2.1) Increment index every iteration - we are going through preOrder array one by one.
 * 2.2) To form the left node pass start - 0, end - index of the node in preOrder - 1.
 * 2.3) If start > end, there is no node.
 * 2.4) To form the right node, pass start - index of the element in preOrder + 1, end - preOrder.length - 1.
 */
public class BuildTree {

    static Map<Integer, Integer> map;
    static int index;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        index = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, preorder.length - 1, preorder);
    }

    private static TreeNode buildTree(int start, int end, int[] preorder) {
        if (start > end) {
            return null;
        }
        var rootValue = preorder[index];
        var rootNode = new TreeNode(rootValue);
        index++;
        rootNode.left = buildTree(start, map.get(rootValue) - 1, preorder);
        rootNode.right = buildTree(map.get(rootValue) + 1, end, preorder);
        return rootNode;
    }
}
