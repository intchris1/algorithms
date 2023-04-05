package com.algorithms.chris.neetcode.binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SearchInRotatedSortedArrayTest {

    @ParameterizedTest
    @MethodSource("searchInRotatedSortedArray")
    void searchInRotatedSortedArray(int[] arg1, int arg2, int expected) {
        var result = SearchInRotatedSortedArray.search(arg1, arg2);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> searchInRotatedSortedArray() {
        return Stream.of(
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
                Arguments.of(new int[]{1}, 0, -1),
                Arguments.of(new int[]{1}, 1, 0),
                Arguments.of(new int[]{1}, 2, -1)
        );
    }
}
