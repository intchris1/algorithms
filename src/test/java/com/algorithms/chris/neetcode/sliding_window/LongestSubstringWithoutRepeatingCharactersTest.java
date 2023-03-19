package com.algorithms.chris.neetcode.sliding_window;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubstringWithoutRepeatingCharactersTest {

    @ParameterizedTest
    @MethodSource("longestSubstringWithoutRepeatingCharacters")
    void longestSubstringWithoutRepeatingCharacters(String arg, int expected) {
        var result = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(arg);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> longestSubstringWithoutRepeatingCharacters() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("aab", 2),
                Arguments.of("dvdf", 3),
                Arguments.of("tmmzuxt", 5)
        );
    }
}
