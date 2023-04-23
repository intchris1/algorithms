package com.algorithms.chris.neetcode.trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DiameterOfBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("diameterOfBinaryTree")
    void diameterOfBinaryTree(TreeNode arg1, int expected) {
        var result = DiameterOfBinaryTree.diameterOfBinaryTree(arg1);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> diameterOfBinaryTree() {
        return Stream.of(
                Arguments.of(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3)),
                        3),
                Arguments.of(new TreeNode(1, new TreeNode(2), null),
                        1)
        );
    }
}
