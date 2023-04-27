package com.algorithms.chris.neetcode.trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KthSmallestElementTest {

    @ParameterizedTest
    @MethodSource("kthSmallestElement")
    void kthSmallestElement(TreeNode arg1, int arg2, int expected) {
        var result = KthSmallestElement.kthSmallest(arg1, arg2);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> kthSmallestElement() {
        return Stream.of(
                Arguments.of(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)),
                        1, 1),
                Arguments.of(new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6)),
                        3, 3),
                Arguments.of(new TreeNode(1, null, new TreeNode(2)), 2, 2)
        );
    }
}
