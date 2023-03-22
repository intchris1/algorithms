package com.algorithms.chris.neetcode.sliding_window;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SlidingWindowMaximumTest {

    @ParameterizedTest
    @MethodSource("slidingWindowMaximum")
    void slidingWindowMaximum(int[] arg, int arg2, int[] expected) {
        var result = SlidingWindowMaximum.slidingWindowMaximum(arg, arg2);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> slidingWindowMaximum() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7}),
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{1, -1}, 1, new int[]{1, -1}),
                Arguments.of(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5, new int[]{10, 10, 9, 2})
        );
    }
}
