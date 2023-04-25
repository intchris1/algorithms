package com.algorithms.chris.neetcode.trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LowestCommonAncestorTest {

    @ParameterizedTest
    @MethodSource("lowestCommonAncestor")
    void lowestCommonAncestor(TreeNode arg1, TreeNode arg2, TreeNode arg3, TreeNode expected) {
        var result = LowestCommonAncestor.lowestCommonAncestor(arg1, arg2, arg3);
        assertThat(result.val).isEqualTo(expected.val);
    }

    private static Stream<Arguments> lowestCommonAncestor() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3),
                                new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9))),
                        new TreeNode(2), new TreeNode(8), new TreeNode(6)),
                Arguments.of(new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3),
                                new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9))),
                        new TreeNode(2), new TreeNode(1), new TreeNode(2))
        );
    }
}
