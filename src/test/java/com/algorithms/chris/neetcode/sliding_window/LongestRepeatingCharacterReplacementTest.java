package com.algorithms.chris.neetcode.sliding_window;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestRepeatingCharacterReplacementTest {

    @ParameterizedTest
    @MethodSource("longestRepeatingCharacterReplacement")
    void longestRepeatingCharacterReplacement(String arg, int k, int expected) {
        var result = LongestRepeatingCharacterReplacement.characterReplacement(arg, k);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> longestRepeatingCharacterReplacement() {
        return Stream.of(
                Arguments.of("ABAB", 2, 4),
                Arguments.of("AABABBA", 1, 4),
                Arguments.of("ABBB", 2, 4),
                Arguments.of("ABCDE", 1, 2),
                Arguments.of("ABAA", 0, 2)
        );
    }
}
