package com.algorithms.chris.time_complexity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TimeComplexityTests {

    @ParameterizedTest
    @MethodSource("missingElement")
    void missingElement(int[] arg, int expected) {
        final int result = MissingElement.solution(arg);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("tapeEquilibrium")
    void tapeEquilibrium(int[] arg, int expected) {
        final int result = TapeEquilibrium.solution(arg);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> tapeEquilibrium() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 2, 4, 3}, 1),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 1000}, 979),
                Arguments.of(new int[]{2001, 1}, 2000),
                Arguments.of(new int[]{-1000, 1000}, 2000),
                Arguments.of(new int[]{1, 2}, 1),
                Arguments.of(new int[]{3, 1}, 2)
        );
    }

    private static Stream<Arguments> missingElement() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1, 5}, 4),
                Arguments.of(new int[]{0}, 1),
                Arguments.of(new int[]{1}, 2),
                Arguments.of(new int[]{1, 2}, 3),
                Arguments.of(new int[]{3, 1}, 2),
                Arguments.of(new int[]{Integer.MAX_VALUE - 2, Integer.MAX_VALUE}, Integer.MAX_VALUE - 1)
        );
    }
}
