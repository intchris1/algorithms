package com.algorithms.chris.neetcode.trees;

import java.util.LinkedList;

/**
 * Сереализовать и десериализовать дерево.
 * Решение: поиск в ширину.
 * <p>
 * Serialize and deserialize a tree.
 * Solution: breadth first search.
 */
public class CodecBfs {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        var stringBuilder = new StringBuilder();
        stringBuilder.append(root.val).append(",");
        while (!queue.isEmpty()) {
            var length = queue.size();
            for (int i = 0; i < length; i++) {
                var elem = queue.removeFirst();
                if (elem.left != null) {
                    queue.add(elem.left);
                    stringBuilder.append(elem.left.val);
                } else {
                    stringBuilder.append("n");
                }
                stringBuilder.append(",");
                if (elem.right != null) {
                    queue.add(elem.right);
                    stringBuilder.append(elem.right.val);
                } else {
                    stringBuilder.append("n");
                }
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }

    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        var queue = new LinkedList<TreeNode>();
        int startIndex = data.indexOf(",");
        var result = new TreeNode(Integer.parseInt(data.substring(0, startIndex)));
        queue.add(result);
        var charArr = data.toCharArray();
        boolean isLeft = true;
        StringBuilder currentVal = new StringBuilder();
        for (int i = startIndex + 1; i < charArr.length; i++) {
            if (charArr[i] == ',') {
                var value = currentVal.toString();
                TreeNode newNode = null;
                if (!value.equals("n")) {
                    newNode = new TreeNode(Integer.parseInt(value));
                    queue.add(newNode);
                }
                currentVal = new StringBuilder();
                if (isLeft) {
                    queue.getFirst().left = newNode;
                    isLeft = false;
                } else {
                    queue.removeFirst().right = newNode;
                    isLeft = true;
                }
            } else {
                currentVal.append(data.charAt(i));
            }
        }
        return result;
    }
}