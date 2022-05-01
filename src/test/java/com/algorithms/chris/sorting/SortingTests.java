package com.algorithms.chris.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortingTests {

    @ParameterizedTest
    @MethodSource("maxProductOfThree")
    void maxProductOfThree(int[] input, int expected) {
        final int result = MaxProductOfThree.solution(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("triangle")
    void triangle(int[] input, int expected) {
        final int result = Triangle.solution(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("numberOfDiscIntersections")
    void numberOfDiscIntersections(int[] input, int expected) {
        final int result = NumberOfDiscIntersections.solution(input);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> numberOfDiscIntersections() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 2, 1, 4, 0}, 11),
                Arguments.of(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}, 1),
                Arguments.of(new int[]{49000, 0}, 1),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1, 1, 1}, 3),
                Arguments.of(new int[]{0, 0, 0}, 0),
                Arguments.of(new int[]{1, 2147483647, 0}, 2)
        );
    }

    private static Stream<Arguments> triangle() {
        return Stream.of(
                Arguments.of(new int[]{10, 2, 5, 1, 8, 20}, 1),
                Arguments.of(new int[]{0, 0}, 0),
                Arguments.of(new int[]{0, 0, 1}, 0),
                Arguments.of(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE / 2, Integer.MAX_VALUE - (Integer.MAX_VALUE / 2)}, 0),
                Arguments.of(new int[]{1, 1, -1}, 0),
                Arguments.of(new int[]{10, 50, 5, 1}, 0)
        );
    }

    private static Stream<Arguments> maxProductOfThree() {
        return Stream.of(
                Arguments.of(new int[]{-3, 1, 2, -2, 5, 6}, 60),
                Arguments.of(new int[]{1, 2, 1}, 2),
                Arguments.of(new int[]{1, 2, 3}, 6),
                Arguments.of(new int[]{1, 1, 1}, 1),
                Arguments.of(new int[]{-1000, 1000, -1000, 1000, 999, -1000}, 1000000000),
                Arguments.of(new int[]{-5, -6, -4, -7, -10}, -120)
        );
    }
}
