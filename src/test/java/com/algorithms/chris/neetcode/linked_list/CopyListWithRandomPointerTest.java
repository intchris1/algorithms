package com.algorithms.chris.neetcode.linked_list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.algorithms.chris.neetcode.linked_list.CopyListWithRandomPointer.Node;
import static org.assertj.core.api.Assertions.assertThat;

class CopyListWithRandomPointerTest {

    @ParameterizedTest
    @MethodSource("copyListWithRandomPointer")
    void copyListWithRandomPointer(Node arg1, Node expected) {
        var result = CopyListWithRandomPointer.copyRandomList(arg1);
        while (expected != null) {
            assertThat(result.val).isEqualTo(expected.val);
            if (result.next != null) {
                assertThat(result.next.val).isEqualTo(expected.next.val);
            } else {
                assertThat(expected.next).isNull();
            }
            if (result.random != null) {
                assertThat(result.random.val).isEqualTo(expected.random.val);
            } else {
                assertThat(expected.random).isNull();
            }
            expected = expected.next;
            result = result.next;
        }
    }

    private static Stream<Arguments> copyListWithRandomPointer() {
        return Stream.of(
                Arguments.of(
                        getFirstTestNode(),
                        getFirstTestNode()
                ),
                Arguments.of(
                        getSecondTestNode(),
                        getSecondTestNode()
                ),
                Arguments.of(
                        getThirdTestNode(),
                        getThirdTestNode()
                )
        );
    }

    private static Node getFirstTestNode() {
        var first = new Node(7);
        var second = new Node(13);
        var third = new Node(11);
        var fourth = new Node(10);
        var fifth = new Node(1);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        second.random = first;
        third.random = fifth;
        fourth.random = third;
        fifth.random = first;
        return first;
    }

    private static Node getSecondTestNode() {
        var first = new Node(1);
        var second = new Node(2);
        first.next = second;
        first.random = second;
        second.random = second;
        return first;
    }

    private static Node getThirdTestNode() {
        var first = new Node(3);
        var second = new Node(3);
        var third = new Node(3);
        first.next = second;
        second.next = third;
        second.random = first;
        return first;
    }
}
