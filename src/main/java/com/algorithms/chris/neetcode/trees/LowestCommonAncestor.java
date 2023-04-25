package com.algorithms.chris.neetcode.trees;

/**
 * Найти наинизшего общего предка двух нод.
 * Решение:
 * 1) Если обе ноды справа (их значения больше), двигаемся вправо.
 * 2) Если обе ноды слева (их значения меньше), двигаемся влево.
 * 3) Иначе - вернуть текущую ноду.
 * <p>
 * Find lowest common ancestor of two nodes.
 * Solution:
 * 1) If both nodes are on the right (their values are bigger), move right.
 * 2) If both nodes are on the left (their values are smaller) move left.
 * 3) Else - return current node.
 */
public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var cur = root;
        while (cur != null) {
            if (cur.val < p.val && cur.val < q.val) {
                cur = cur.right;
            } else if (cur.val > p.val && cur.val > q.val) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }
}
