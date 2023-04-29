package com.algorithms.chris.neetcode.trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BuildTreeTest {

    @ParameterizedTest
    @MethodSource("buildTree")
    void buildTree(int[] arg1, int[] arg2, TreeNode expected) {
        var result = BuildTree.buildTree(arg1, arg2);
        assertThat(SameTree.isSameTree(expected, result)).isEqualTo(true);
    }

    private static Stream<Arguments> buildTree() {
        return Stream.of(
                Arguments.of(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7},
                        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))))
        );
    }
}
