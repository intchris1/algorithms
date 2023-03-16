package com.algorithms.chris.neetcode.two_pointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ContainerWithMostWaterTest {

    @ParameterizedTest
    @MethodSource("containerWithMostWater")
    void containerWithMostWater(int[] arg, int expected) {
        var result = ContainerWithMostWater.maxArea(arg);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> containerWithMostWater() {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.of(new int[]{1, 1}, 1)
        );
    }
}
