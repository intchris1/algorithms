package com.algorithms.chris.neetcode.trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RightSideViewTest {

    @ParameterizedTest
    @MethodSource("rightSideView")
    void rightSideView(TreeNode arg1, List<Integer> expected) {
        var result = RightSideView.rightSideView(arg1);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> rightSideView() {
        return Stream.of(
                Arguments.of(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4))),
                        List.of(1, 3, 4)),
                Arguments.of(new TreeNode(1, null, new TreeNode(3)),
                        List.of(1, 3)),
                Arguments.of(null, List.of()),
                Arguments.of(new TreeNode(1, new TreeNode(2), null), List.of(1, 2))
        );
    }
}
