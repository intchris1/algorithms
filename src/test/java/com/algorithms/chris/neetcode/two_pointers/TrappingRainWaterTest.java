package com.algorithms.chris.neetcode.two_pointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TrappingRainWaterTest {

    @ParameterizedTest
    @MethodSource("trappingRainWater")
    void trappingRainWater(int[] arg, int expected) {
        var result = TrappingRainWater.trap(arg);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> trappingRainWater() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
                Arguments.of(new int[]{4, 2, 0, 3, 2, 5}, 9)
        );
    }
}
