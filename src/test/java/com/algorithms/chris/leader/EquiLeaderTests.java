package com.algorithms.chris.leader;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class EquiLeaderTests {

    @ParameterizedTest
    @MethodSource("equiLeader")
    void equiLeader(int[] input, int expected) {
        final int result = EquiLeader.solution(input);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> equiLeader() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 4, 4, 4, 2}, 2),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1}, 6),
                Arguments.of(new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 0),
                Arguments.of(new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 0),
                Arguments.of(new int[]{1, 1, 0}, 0),
                Arguments.of(new int[]{1, 1, 1, 0}, 1),
                Arguments.of(new int[]{0, 0}, 1)
        );
    }
}
