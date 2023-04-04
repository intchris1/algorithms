package com.algorithms.chris.neetcode.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DailyTemperaturesTest {

    @ParameterizedTest
    @MethodSource("dailyTemperatures")
    void dailyTemperatures(int[] arg, int[] expected) {
        var result = DailyTemperatures.dailyTemperatures(arg);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> dailyTemperatures() {
        return Stream.of(
                Arguments.of(new int[]{73, 74, 75, 71, 69, 72, 76, 73}, new int[]{1, 1, 4, 2, 1, 1, 0, 0}),
                Arguments.of(new int[]{30, 40, 50, 60}, new int[]{1, 1, 1, 0}),
                Arguments.of(new int[]{30, 60, 90}, new int[]{1, 1, 0}),
                Arguments.of(new int[]{}, new int[]{})
        );
    }
}
