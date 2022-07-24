package com.algorithms.chris.prime_and_composite_numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CountFactorsTest {

    @ParameterizedTest
    @MethodSource("countFactors")
    void countFactors(int arg, int expected) {
        final int result = CountFactors.solution(arg);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> countFactors() {
        return Stream.of(
                Arguments.of(5, 2),
                Arguments.of(24, 8),
                Arguments.of(Integer.MAX_VALUE, 2),
                Arguments.of(Integer.MAX_VALUE - 1, 192),
                Arguments.of(25, 3),
                Arguments.of(0, 0),
                Arguments.of(292992290, 8)
        );
    }
}
