package com.algorithms.chris.neetcode.trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GoodNodesTest {

    @ParameterizedTest
    @MethodSource("goodNodes")
    void goodNodes(TreeNode arg1, int expected) {
        var result = GoodNodes.goodNodes(arg1);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> goodNodes() {
        return Stream.of(
                Arguments.of(new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5))),
                        4),
                Arguments.of(new TreeNode(3, new TreeNode(3, new TreeNode(4), new TreeNode(2)), null),
                        3),
                Arguments.of(new TreeNode(1), 1)
        );
    }
}
