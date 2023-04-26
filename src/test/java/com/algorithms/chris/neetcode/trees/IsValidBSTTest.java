package com.algorithms.chris.neetcode.trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IsValidBSTTest {

    @ParameterizedTest
    @MethodSource("isValidBST")
    void isValidBST(TreeNode arg1, boolean expected) {
        var result = IsValidBST.isValidBST(arg1);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> isValidBST() {
        return Stream.of(
                Arguments.of(new TreeNode(2, new TreeNode(1), new TreeNode(3)), true),
                Arguments.of(new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6))), false),
                Arguments.of(new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7))), false)
        );
    }
}
