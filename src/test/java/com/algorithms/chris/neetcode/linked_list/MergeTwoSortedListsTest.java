package com.algorithms.chris.neetcode.linked_list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.algorithms.chris.neetcode.linked_list.MergeTwoSortedLists.ListNode;
import static org.assertj.core.api.Assertions.assertThat;

class MergeTwoSortedListsTest {

    @ParameterizedTest
    @MethodSource("mergeTwoSortedLists")
    void mergeTwoSortedLists(ListNode arg1, ListNode arg2, List<Integer> expected) {
        var result = MergeTwoSortedLists.mergeTwoLists(arg1, arg2);
        var resultToList = new ArrayList<Integer>();
        var elem = result;
        while (elem != null) {
            resultToList.add(elem.val);
            elem = elem.next;
        }
        assertThat(resultToList).isEqualTo(expected);
    }

    private static Stream<Arguments> mergeTwoSortedLists() {
        return Stream.of(
                Arguments.of(
                        new MergeTwoSortedLists.ListNode(1, new ListNode(2, new ListNode(4))),
                        new ListNode(1, new ListNode(3, new ListNode(4))),
                        List.of(1, 1, 2, 3, 4, 4)
                ),
                Arguments.of(
                        null,
                        null,
                        List.of()
                ),
                Arguments.of(
                        null,
                        new ListNode(0),
                        List.of(0)
                ),
                Arguments.of(
                        new ListNode(1),
                        null,
                        List.of(1)
                )
        );
    }
}
