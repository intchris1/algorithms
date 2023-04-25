package com.algorithms.chris.neetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var length = queue.size();
            var currentList = new ArrayList<Integer>();
            list.add(currentList);
            for (int i = 0; i < length; i++) {
                var removed = queue.removeFirst();
                currentList.add(removed.val);
                if (removed.left != null) {
                    queue.addLast(removed.left);
                }
                if (removed.right != null) {
                    queue.addLast(removed.right);
                }
            }
        }
        return list;
    }
}
