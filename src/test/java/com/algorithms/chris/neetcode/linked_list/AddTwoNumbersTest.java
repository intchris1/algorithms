package com.algorithms.chris.neetcode.linked_list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.algorithms.chris.util.TestUtil.listToListNodes;
import static org.assertj.core.api.Assertions.assertThat;

class AddTwoNumbersTest {

    @ParameterizedTest
    @MethodSource("addTwoNumbersTest")
    void addTwoNumbersTest(ListNode arg1, ListNode arg2, List<Integer> expected) {
        var result = AddTwoNumbers.addTwoNumbers(arg1, arg2);
        var resultToList = new ArrayList<Integer>();
        var elem = result;
        while (elem != null) {
            resultToList.add(elem.val);
            elem = elem.next;
        }
        assertThat(resultToList).isEqualTo(expected);
    }

    private static Stream<Arguments> addTwoNumbersTest() {
        return Stream.of(
                Arguments.of(
                        listToListNodes(2, 4, 3),
                        listToListNodes(5, 6, 4),
                        List.of(7, 0, 8)
                ),
                Arguments.of(
                        listToListNodes(0),
                        listToListNodes(0),
                        List.of(0)
                ),
                Arguments.of(
                        listToListNodes(9, 9, 9, 9, 9, 9, 9),
                        listToListNodes(9, 9, 9, 9),
                        List.of(8, 9, 9, 9, 0, 0, 0, 1)
                ),
                Arguments.of(
                        listToListNodes(2, 4, 9),
                        listToListNodes(5, 6, 4, 9),
                        List.of(7, 0, 4, 0, 1)
                ),
                Arguments.of(
                        listToListNodes(9),
                        listToListNodes(1, 9, 9, 9, 9, 9, 9, 9, 9, 9),
                        List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
                ),
                Arguments.of(
                        listToListNodes(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
                        listToListNodes(5, 6, 4),
                        List.of(6, 6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
                )
        );
    }
}
