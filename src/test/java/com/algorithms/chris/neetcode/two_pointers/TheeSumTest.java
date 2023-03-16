package com.algorithms.chris.neetcode.two_pointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TheeSumTest {

    @ParameterizedTest
    @MethodSource("threeSum")
    void threeSum(int[] arg, List<List<Integer>> expected) {
        var result = ThreeSum.threeSum(arg);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> threeSum() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 1, 2, -1, -4}, List.of(List.of(-1, -1, 2), List.of(-1, 0, 1))),
                Arguments.of(new int[]{0, 1, 1}, List.of()),
                Arguments.of(new int[]{0, 0, 0}, List.of(List.of(0, 0, 0))),
                Arguments.of(new int[]{-3, -3, 1, 2, 3, 4}, List.of(List.of(-3, 1, 2)))
        );
    }
}
