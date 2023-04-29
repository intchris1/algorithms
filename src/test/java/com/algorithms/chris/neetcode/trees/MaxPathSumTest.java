package com.algorithms.chris.neetcode.trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxPathSumTest {

    @ParameterizedTest
    @MethodSource("maxPathSum")
    void maxPathSum(TreeNode arg1, int expected) {
        var result = MaxPathSum.maxPathSum(arg1);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> maxPathSum() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(1, new TreeNode(2), new TreeNode(3)), 6),
                Arguments.of(
                        new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))), 42)
        );
    }
}
