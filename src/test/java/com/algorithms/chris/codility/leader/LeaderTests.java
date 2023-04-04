package com.algorithms.chris.codility.leader;

import com.algorithms.chris.codility.leader.Dominator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LeaderTests {

    @ParameterizedTest
    @MethodSource("dominator")
    void dominator(int[] input, int expected) {
        final int result = Dominator.solution(input);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> dominator() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 3, 4, 3, 3, 3, -1}, 6),
                Arguments.of(new int[]{3, 3, 3, 3, 3, 3, 3, 3}, 4),
                Arguments.of(new int[]{1, 1, 1, 1, 2, 2, 2, 2}, -1),
                Arguments.of(new int[]{2, 3, 2, 3, 2, 3, 2, 3, 2}, 8),
                Arguments.of(new int[]{}, -1),
                Arguments.of(new int[]{1}, 0)
        );
    }
}
