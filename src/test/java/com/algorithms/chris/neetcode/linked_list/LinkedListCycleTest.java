package com.algorithms.chris.neetcode.linked_list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.algorithms.chris.util.TestUtil.listToListNodes;
import static com.algorithms.chris.util.TestUtil.listToListNodesAsList;
import static org.assertj.core.api.Assertions.assertThat;

class LinkedListCycleTest {

    @ParameterizedTest
    @MethodSource("linkedListCycle")
    void linkedListCycle(ListNode arg1, boolean expected) {
        var result = LinkedListCycle.hasCycle(arg1);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> linkedListCycle() {
        return Stream.of(
                Arguments.of(getFirstLinkedList(), true),
                Arguments.of(getSecondLinkedList(), true),
                Arguments.of(listToListNodes(1), false)
        );
    }

    private static ListNode getFirstLinkedList() {
        var commonList = listToListNodesAsList(3, 2, 0, -4);
        commonList.get(commonList.size() - 1).next = commonList.get(1);
        return commonList.get(0);
    }

    private static ListNode getSecondLinkedList() {
        var commonList = listToListNodesAsList(1, 2);
        commonList.get(commonList.size() - 1).next = commonList.get(0);
        return commonList.get(0);
    }
}
