package com.algorithms.chris.neetcode.linked_list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.algorithms.chris.util.TestUtil.listToListNodes;
import static org.assertj.core.api.Assertions.assertThat;

class ReverseNodesInKGroupTest {

    @ParameterizedTest
    @MethodSource("reverseNodesInKGroup")
    void reverseNodesInKGroup(ListNode arg1, int arg2, List<Integer> expected) {
        var result = ReverseNodesInKGroup.reverseKGroup(arg1, arg2);
        var resultToList = new ArrayList<Integer>();
        var elem = result;
        while (elem != null) {
            resultToList.add(elem.val);
            elem = elem.next;
        }
        assertThat(resultToList).isEqualTo(expected);
    }

    private static Stream<Arguments> reverseNodesInKGroup() {
        return Stream.of(
                Arguments.of(listToListNodes(1, 2, 3, 4, 5), 2, List.of(2, 1, 4, 3, 5)),
                Arguments.of(listToListNodes(1, 2, 3, 4, 5), 3, List.of(3, 2, 1, 4, 5))
        );
    }
}
