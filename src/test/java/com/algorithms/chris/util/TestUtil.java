package com.algorithms.chris.util;

import com.algorithms.chris.neetcode.linked_list.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtil {


    public static ListNode listToListNodes(List<Integer> list) {
        return listToListNodesAsList(list).get(0);
    }

    public static List<ListNode> listToListNodesAsList(List<Integer> list) {
        var head = new ListNode();
        var linkedList = new ArrayList<ListNode>(list.size());
        for (Integer integer : list) {
            head.next = new ListNode(integer);
            linkedList.add(head.next);
            head = head.next;
        }
        return linkedList;
    }


    public static ListNode listToListNodes(Integer... array) {
        List<Integer> list = Arrays.asList(array);
        return listToListNodes(list);
    }

    public static List<ListNode> listToListNodesAsList(Integer... array) {
        List<Integer> list = Arrays.asList(array);
        return listToListNodesAsList(list);
    }

    public static Object[] args(Object... args) {
        return args;
    }
}
