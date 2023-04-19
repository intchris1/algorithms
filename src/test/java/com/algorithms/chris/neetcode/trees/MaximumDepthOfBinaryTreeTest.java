package com.algorithms.chris.neetcode.trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumDepthOfBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("maximumDepthOfBinaryTree")
    void maxDepthBreadthFirstSearch(TreeNode arg1, int expected) {
        var result = MaximumDepthOfBinaryTree.maxDepthBreadthFirstSearch(arg1);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("maximumDepthOfBinaryTree")
    void maxDepthDepthFirstSearch(TreeNode arg1, int expected) {
        var result = MaximumDepthOfBinaryTree.maxDepthDepthFirstSearch(arg1);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("maximumDepthOfBinaryTree")
    void maxDepthBreadthFirstIterativeSearch(TreeNode arg1, int expected) {
        var result = MaximumDepthOfBinaryTree.maxDepthBreadthFirstIterativeSearch(arg1);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> maximumDepthOfBinaryTree() {
        return Stream.of(
                Arguments.of(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        3),
                Arguments.of(new TreeNode(1, null, new TreeNode(2)), 2)
        );
    }
}
