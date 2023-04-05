package com.algorithms.chris.neetcode.binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MedianOfTwoSortedArraysTest {

    @ParameterizedTest
    @MethodSource("medianOfTwoSortedArrays")
    void medianOfTwoSortedArrays(int[] arg1, int[] arg2, double expected) {
        var result = MedianOfTwoSortedArrays.findMedianSortedArrays(arg1, arg2);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> medianOfTwoSortedArrays() {
        return Stream.of(
                Arguments.of(new int[]{1, 3}, new int[]{2}, 2),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 2.5)
        );
    }
}
