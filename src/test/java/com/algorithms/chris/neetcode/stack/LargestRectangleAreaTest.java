package com.algorithms.chris.neetcode.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LargestRectangleAreaTest {

    @ParameterizedTest
    @MethodSource("largestRectangleArea")
    void largestRectangleArea(int[] arg1, int expected) {
        var result = LargestRectangleArea.largestRectangleArea(arg1);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> largestRectangleArea() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 5, 6, 2, 3}, 10),
                Arguments.of(new int[]{2, 4}, 4)
        );
    }
}
