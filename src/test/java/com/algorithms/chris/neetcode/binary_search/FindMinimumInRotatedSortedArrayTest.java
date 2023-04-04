package com.algorithms.chris.neetcode.binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindMinimumInRotatedSortedArrayTest {

    @ParameterizedTest
    @MethodSource("findMinimumInRotatedSortedArray")
    void findMinimumInRotatedSortedArray(int[] arg1, int expected) {
        var result = FindMinimumInRotatedSortedArray.findMin(arg1);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> findMinimumInRotatedSortedArray() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 5, 1, 2}, 1),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0),
                Arguments.of(new int[]{11, 13, 15, 17}, 11)
        );
    }
}
