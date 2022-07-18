package com.algorithms.chris.max_slice_problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxDoubleSliceTest {

    @ParameterizedTest
    @MethodSource("maxDoubleSlice")
    void maxDoubleSlice(int[] input, int expected) {
        final int result = MaxDoubleSlice.solution(input);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> maxDoubleSlice() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 6, -1, 4, 5, -1, 2,}, 17),
                Arguments.of(new int[]{0, 10, -5, -2, 0}, 10),
                Arguments.of(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE}, 0),
                Arguments.of(new int[]{-10, 10, -10, 10}, 10),
                Arguments.of(new int[]{0, -1, 1, -1, 1, 0}, 2)
        );
    }
}