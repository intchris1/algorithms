package com.algorithms.chris.neetcode.arrrays_hashing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestConsecutiveSequenceTest {

    @ParameterizedTest
    @MethodSource("longestConsecutive")
    void longestConsecutive(int[] arg, int expected) {
        var result = LongestConsecutiveSequence.longestConsecutive(arg);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> longestConsecutive() {
        return Stream.of(
                Arguments.of(new int[]{100, 4, 200, 1, 3, 2}, 4),
                Arguments.of(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9)
        );
    }
}
