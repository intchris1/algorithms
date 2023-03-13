package com.algorithms.chris.neetcode.arrrays_hashing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IsAnagramTest {

    @ParameterizedTest
    @MethodSource("isAnagram")
    void isAnagram(String first, String second, boolean expected) {
        var result = IsAnagram.isAnagram(first, second);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> isAnagram() {
        return Stream.of(
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false)
        );
    }
}
