package com.algorithms.chris.neetcode.two_pointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidPalindromeTest {

    @ParameterizedTest
    @MethodSource("validPalindrome")
    void validPalindrome(String arg, boolean expected) {
        var result = ValidPalindrome.validPalindrome(arg);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> validPalindrome() {
        return Stream.of(
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("race a car", false),
                Arguments.of(" ", true),
                Arguments.of("0P", false)
        );
    }
}
