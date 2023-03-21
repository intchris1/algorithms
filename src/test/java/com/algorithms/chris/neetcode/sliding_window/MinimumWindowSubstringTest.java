package com.algorithms.chris.neetcode.sliding_window;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumWindowSubstringTest {

    @ParameterizedTest
    @MethodSource("minWindow")
    void minWindow(String arg1, String arg2, String expected) {
        var result = MinimumWindowSubstring.minWindowPassingSolution(arg1, arg2);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> minWindow() {
        return Stream.of(
                Arguments.of("ADOBECODEBANC", "ABC", "BANC"),
                Arguments.of("a", "a", "a"),
                Arguments.of("a", "aa", ""),
                Arguments.of("a", "b", ""),
                Arguments.of("bba", "ab", "ba"),
                Arguments.of("cabefgecdaecf", "cae", "aec"),
                Arguments.of("abcabdebac", "cda", "cabd"),
                Arguments.of("aaabbaaba", "abbb", "bbaab")
        );
    }
}
