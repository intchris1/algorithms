package com.algorithms.chris.max_slice_problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxProfitTest {

    @ParameterizedTest
    @MethodSource("maxProfit")
    void maxProfit(int[] input, int expected) {
        final int result = MaxProfit.solution(input);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> maxProfit() {
        return Stream.of(
                Arguments.of(new int[]{23171, 21011, 21123, 21366, 21013, 21367}, 356),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{0, 400_000, 0, 500_000}, 500_000)
        );
    }
}