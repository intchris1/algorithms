package com.algorithms.chris.neetcode.linked_list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.algorithms.chris.neetcode.linked_list.ReorderLinkedList.ListNode;
import static org.assertj.core.api.Assertions.assertThat;

class ReorderLinkedListTest {

    @ParameterizedTest
    @MethodSource("reorderList")
    void reorderList(ListNode arg1, List<Integer> expected) {
        ReorderLinkedList.reorderList(arg1);
        var resultToList = new ArrayList<Integer>();
        var elem = arg1;
        while (elem != null) {
            resultToList.add(elem.val);
            elem = elem.next;
        }
        assertThat(resultToList).isEqualTo(expected);
    }

    private static Stream<Arguments> reorderList() {
        return Stream.of(
                Arguments.of(
                        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))),
                        List.of(1, 4, 2, 3)
                ),
                Arguments.of(
                        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                        List.of(1, 5, 2, 4, 3)
                ),
                Arguments.of(
                        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7))))))),
                        List.of(1, 7, 2, 6, 3, 5, 4)
                ),
                Arguments.of(
                        new ListNode(1),
                        List.of(1)
                ),
                Arguments.of(
                        new ListNode(1, new ListNode(2)),
                        List.of(1, 2)
                )
        );
    }
}
