package com.algorithms.chris.neetcode.trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SameTreeTest {

    @ParameterizedTest
    @MethodSource("sameTree")
    void sameTree(TreeNode arg1,TreeNode arg2, boolean expected) {
        var result = SameTree.isSameTree(arg1, arg2);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> sameTree() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        true),
                Arguments.of(
                        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7, new TreeNode(5), null))),
                        false)
        );
    }
}
