package com.algorithms.chris.prime_and_composite_numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FlagsTest {

    @ParameterizedTest
    @MethodSource("flags")
    void flags(int[] arg, int expected) {
        final int result = Flags.solution(arg);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> flags() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}, 3),
                Arguments.of(new int[]{1, 1}, 0),
                Arguments.of(new int[]{1, 1, -1}, 0),
                Arguments.of(new int[]{1}, 0)
        );
    }
}
