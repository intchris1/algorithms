package com.algorithms.chris.neetcode.trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeLevelOrderTraversalTest {

    @ParameterizedTest
    @MethodSource("levelOrder")
    void levelOrder(TreeNode arg1, List<List<Integer>> expected) {
        var result = BinaryTreeLevelOrderTraversal.levelOrder(arg1);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> levelOrder() {
        return Stream.of(
                Arguments.of(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        List.of(List.of(3), List.of(9, 20), List.of(15, 7))),
                Arguments.of(new TreeNode(1), List.of(List.of(1))),
                Arguments.of(null, List.of())
        );
    }
}
