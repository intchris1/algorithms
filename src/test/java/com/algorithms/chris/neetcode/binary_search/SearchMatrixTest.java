package com.algorithms.chris.neetcode.binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SearchMatrixTest {

    @ParameterizedTest
    @MethodSource("searchMatrix")
    void searchMatrix(int[][] arg1, int arg2, boolean expected) {
        var result = SearchMatrix.searchMatrix(arg1, arg2);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> searchMatrix() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{1, 3, 5, 7}, new int[]{10, 11, 16, 20}, new int[]{23, 30, 34, 60}}, 3, true),
                Arguments.of(new int[][]{new int[]{1, 3, 5, 7}, new int[]{10, 11, 16, 20}, new int[]{23, 30, 34, 60}}, 13, false),
                Arguments.of(new int[][]{new int[]{1}}, 0, false),
                Arguments.of(new int[][]{new int[]{1}, new int[]{3}}, 3, true),
                Arguments.of(new int[][]{new int[]{1, 3, 5, 7}, new int[]{10, 11, 16, 20}, new int[]{23, 30, 34, 50}}, 30, true)
        );
    }
}
