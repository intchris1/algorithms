package com.algorithms.chris.additional;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MostFrequentCommonPrefixTest {

    @ParameterizedTest
    @MethodSource("mostFrequentCommonPrefix")
    void mostFrequentCommonPrefix(String[] arg, String expected) {
        final String result = MostFrequentCommonPrefix.mostFrequentCommonPrefix(arg);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> mostFrequentCommonPrefix() {
        return Stream.of(
                Arguments.of(new String[]{"pref1", "nya1", "pref2", "pref3", "nya2"}, "pref"),
                Arguments.of(new String[]{"test1", "test2", "tes3", "test4", "nya2"}, "tes"),
                Arguments.of(new String[]{"aaad", "aaac", "aaad", "aaac", "aaac"}, "aaa"),
                Arguments.of(new String[]{"1", "2"}, ""),
                Arguments.of(new String[]{}, "")
        );
    }
}
