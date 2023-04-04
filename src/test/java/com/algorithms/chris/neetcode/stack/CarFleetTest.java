package com.algorithms.chris.neetcode.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarFleetTest {

    @ParameterizedTest
    @MethodSource("carFleet")
    void carFleet(int arg1, int[] arg2, int[] arg3, int expected) {
        var result = CarFleet.carFleet(arg1, arg2, arg3);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> carFleet() {
        return Stream.of(
                Arguments.of(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}, 3),
                Arguments.of(10, new int[]{3}, new int[]{3}, 1),
                Arguments.of(100, new int[]{0, 2, 4}, new int[]{4, 2, 1}, 1)
        );
    }
}
