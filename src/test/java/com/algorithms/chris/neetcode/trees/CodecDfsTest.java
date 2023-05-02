package com.algorithms.chris.neetcode.trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CodecDfsTest {

    @ParameterizedTest
    @MethodSource("codec")
    void codec(TreeNode arg1) {
        var codec = new CodecDfs();
        var serialized = codec.serialize(arg1);
        var deserialized = codec.deserialize(serialized);
        assertThat(SameTree.isSameTree(arg1, deserialized)).isTrue();
    }

    private static Stream<Arguments> codec() {
        return Stream.of(
                Arguments.of(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)))),
                Arguments.of(new TreeNode(11, new TreeNode(222), new TreeNode(39, new TreeNode(4), new TreeNode(5))))
        );
    }
}
