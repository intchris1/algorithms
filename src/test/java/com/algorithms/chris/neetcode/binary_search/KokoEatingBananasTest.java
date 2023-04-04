package com.algorithms.chris.neetcode.binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KokoEatingBananasTest {

    @ParameterizedTest
    @MethodSource("kokoEatingBananas")
    void kokoEatingBananas(int[] arg1, int arg2, int expected) {
        var result = KokoEatingBananas.minEatingSpeed(arg1, arg2);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> kokoEatingBananas() {
        return Stream.of(
                Arguments.of(new int[]{3, 6, 7, 11}, 8, 4),
                Arguments.of(new int[]{30, 11, 23, 4, 20}, 5, 30),
                Arguments.of(new int[]{30, 11, 23, 4, 20}, 6, 23)
        );
    }
}
