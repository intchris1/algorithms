package com.algorithms.chris.neetcode.two_pointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumSortedTest {

    @ParameterizedTest
    @MethodSource("twoSumSorted")
    void twoSumSorted(int[] arg, int target, int[] expected) {
        var result = TwoSumSorted.twoSumSorted(arg, target);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> twoSumSorted() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}),
                Arguments.of(new int[]{2, 3, 4}, 6, new int[]{1, 3}),
                Arguments.of(new int[]{-1, 0}, -1, new int[]{1, 2})
        );
    }
}
