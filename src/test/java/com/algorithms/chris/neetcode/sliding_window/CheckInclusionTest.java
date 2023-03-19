package com.algorithms.chris.neetcode.sliding_window;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CheckInclusionTest {

    @ParameterizedTest
    @MethodSource("checkInclusion")
    void checkInclusion(String arg, String arg2, boolean expected) {
        var result = CheckInclusion.checkInclusion(arg, arg2);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> checkInclusion() {
        return Stream.of(
                Arguments.of("ab", "eidbaooo", true),
                Arguments.of("ab", "eidboaoo", false),
                Arguments.of("adc", "dcda", true),
                Arguments.of("hello", "ooolleoooleh", false),
                Arguments.of("abc", "bbbca", true)
        );
    }
}
