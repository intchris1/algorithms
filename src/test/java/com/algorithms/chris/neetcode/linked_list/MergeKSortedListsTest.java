package com.algorithms.chris.neetcode.linked_list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.algorithms.chris.util.TestUtil.listToListNodes;
import static org.assertj.core.api.Assertions.assertThat;

class MergeKSortedListsTest {

    @ParameterizedTest
    @MethodSource("mergeKSortedLists")
    void mergeKSortedLists(ListNode[] arg1, List<Integer> expected) {
        var result = MergeKSortedLists.mergeKLists(arg1);
        var resultToList = new ArrayList<Integer>();
        var elem = result;
        while (elem != null) {
            resultToList.add(elem.val);
            elem = elem.next;
        }
        assertThat(resultToList).isEqualTo(expected);
    }

    private static Stream<Arguments> mergeKSortedLists() {
        return Stream.of(
                Arguments.of(
                        new ListNode[]{
                                listToListNodes(1, 4, 5),
                                listToListNodes(1, 3, 4),
                                listToListNodes(2, 6)},
                        List.of(1, 1, 2, 3, 4, 4, 5, 6)),
                Arguments.of(
                        new ListNode[0],
                        List.of()),
                Arguments.of(
                        new ListNode[]{null},
                        List.of())
        );
    }
}
