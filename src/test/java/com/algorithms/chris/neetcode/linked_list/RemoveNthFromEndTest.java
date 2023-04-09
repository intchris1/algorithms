package com.algorithms.chris.neetcode.linked_list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.algorithms.chris.neetcode.linked_list.RemoveNthFromEnd.ListNode;
import static org.assertj.core.api.Assertions.assertThat;

class RemoveNthFromEndTest {

    @ParameterizedTest
    @MethodSource("removeNthFromEnd")
    void removeNthFromEnd(ListNode arg1, int arg2, List<Integer> expected) {
        var result = RemoveNthFromEnd.removeNthFromEnd(arg1, arg2);
        var resultToList = new ArrayList<Integer>();
        var elem = result;
        while (elem != null) {
            resultToList.add(elem.val);
            elem = elem.next;
        }
        assertThat(resultToList).isEqualTo(expected);
    }

    private static Stream<Arguments> removeNthFromEnd() {
        return Stream.of(
                Arguments.of(
                        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                        2,
                        List.of(1, 2, 3, 5)
                ),
                Arguments.of(
                        new ListNode(1),
                        1,
                        List.of()
                ),
                Arguments.of(
                        new ListNode(1, new ListNode(2)),
                        1,
                        List.of(1)
                ),
                Arguments.of(
                        new ListNode(1, new ListNode(2)),
                        2,
                        List.of(2)
                )
        );
    }
}
