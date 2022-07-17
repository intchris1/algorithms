package com.algorithms.chris.max_slice_problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxSliceTest {

    @ParameterizedTest
    @MethodSource("maxSlice")
    void maxSlice(int[] input, int expected) {
        final int result = MaxSlice.solution(input);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> maxSlice() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, -6, 4, 0}, 5),
                Arguments.of(new int[]{Integer.MIN_VALUE}, Integer.MIN_VALUE),
                Arguments.of(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE}, Integer.MIN_VALUE),
                Arguments.of(IntStream.generate(() -> 1_000_000).limit(1_000_000).toArray(), 2_147_000_000),
                Arguments.of(new int[]{-10, 10, 10}, 20),
                Arguments.of(new int[]{-10, 10, -10, 10}, 10)
        );
    }
}