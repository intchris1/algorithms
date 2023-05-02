package com.algorithms.chris.neetcode.trees;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.join;

/**
 * Сереализовать и десериализовать дерево.
 * Решение: поиск в глубину.
 * <p>
 * Serialize and deserialize a tree.
 * Solution: depth first search.
 */
public class CodecDfs {

    public String serialize(TreeNode root) {
        var list = new ArrayList<String>();
        dfsSerialize(root, list);
        return join(",", list);
    }

    private void dfsSerialize(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("n");
        } else {
            list.add(String.valueOf(node.val));
            dfsSerialize(node.left, list);
            dfsSerialize(node.right, list);
        }
    }

    public TreeNode deserialize(String data) {
        var split = data.split(",");
        int[] i = new int[]{0};
        return dfsDeserialize(split, i);
    }

    private TreeNode dfsDeserialize(String[] split, int[] i) {
        String value = split[i[0]];
        i[0]++;
        if ("n".equals(value)) {
            return null;
        } else {
            var node = new TreeNode(Integer.parseInt(value));
            node.left = dfsDeserialize(split, i);
            node.right = dfsDeserialize(split, i);
            return node;
        }
    }
}