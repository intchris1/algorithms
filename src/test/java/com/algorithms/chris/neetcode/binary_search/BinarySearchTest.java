package com.algorithms.chris.neetcode.binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTest {

    @ParameterizedTest
    @MethodSource("binarySearch")
    void binarySearch(int[] arg1, int arg2, int expected) {
        var result = BinarySearch.search(arg1, arg2);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> binarySearch() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
                Arguments.of(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1)
        );
    }
}
