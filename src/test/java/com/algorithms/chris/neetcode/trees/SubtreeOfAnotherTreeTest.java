package com.algorithms.chris.neetcode.trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SubtreeOfAnotherTreeTest {

    @ParameterizedTest
    @MethodSource("subtreeOfAnotherTree")
    void subtreeOfAnotherTree(TreeNode arg1, TreeNode arg2, boolean expected) {
        var result = SubtreeOfAnotherTree.isSubtree(arg1, arg2);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> subtreeOfAnotherTree() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)), new TreeNode(5)),
                        new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                        false),
                Arguments.of(
                        new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5)),
                        new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                        true)
        );
    }
}
