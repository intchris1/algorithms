package com.algorithms.chris.neetcode.arrrays_hashing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ContainsDuplicateTest {

    @ParameterizedTest
    @MethodSource("containsDuplicate")
    void containsDuplicate(int[] arg, boolean expected) {
        var result = ContainsDuplicate.containsDuplicate(arg);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> containsDuplicate() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, false),
                Arguments.of(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }
}
