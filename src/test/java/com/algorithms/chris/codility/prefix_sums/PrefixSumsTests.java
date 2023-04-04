package com.algorithms.chris.codility.prefix_sums;

import com.algorithms.chris.codility.prefix_sums.CountDiv;
import com.algorithms.chris.codility.prefix_sums.GenomicRangeQuery;
import com.algorithms.chris.codility.prefix_sums.MinAvgTwoSlices;
import com.algorithms.chris.codility.prefix_sums.PassingCars;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PrefixSumsTests {

    @ParameterizedTest
    @MethodSource("passingCars")
    void passingCars(int[] arg, int expected) {
        final int result = PassingCars.solution(arg);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("countDiv")
    void countDiv(int A, int B, int K, int expected) {
        final int result = CountDiv.solution(A, B, K);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("genomicRangeQuery")
    void genomicRangeQuery(String S, int[] P, int[] Q, int[] expected) {
        final int[] result = GenomicRangeQuery.solution(S, P, Q);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("minAvgTwoSlices")
    void minAvgTwoSlices(int[] input, int expected) {
        final int result = MinAvgTwoSlices.solution(input);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> minAvgTwoSlices() {
        return Stream.of(
                Arguments.of(new int[]{4, 2, 2, 5, 1, 5, 8}, 1),
                Arguments.of(new int[]{-1, 0}, 0),
                Arguments.of(new int[]{-1, -1, -2, 2}, 1),
                Arguments.of(new int[]{-1, -1, 1, 1}, 0),
                Arguments.of(new int[]{-1, 0, 0, 1}, 0),
                Arguments.of(new int[]{-1, 0, 0}, 0),
                Arguments.of(new int[]{-1, 0, 0, -1, -1, 0, -1, -1, -1, 0}, 3),
                Arguments.of(new int[]{100, 100, 1}, 1),
                Arguments.of(new int[]{4, 2, 2, 5, -100, 5, -100}, 4),
                Arguments.of(new int[]{1, 2}, 0)
        );
    }

    private static Stream<Arguments> genomicRangeQuery() {
        return Stream.of(
                Arguments.of("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}, new int[]{2, 4, 1}),
                Arguments.of("CAAAAAAAAA", new int[]{0, 2, 3}, new int[]{0, 3, 4}, new int[]{2, 1, 1})
        );
    }

    private static Stream<Arguments> countDiv() {
        return Stream.of(
                Arguments.of(6, 11, 2, 3),
                Arguments.of(0, 16, 4, 5),
                Arguments.of(1, 16, 4, 4),
                Arguments.of(1, 15, 4, 3),
                Arguments.of(1, 14, 4, 3),
                Arguments.of(1, 13, 4, 3),
                Arguments.of(3, 13, 4, 3),
                Arguments.of(4, 13, 4, 3),
                Arguments.of(5, 13, 4, 2),
                Arguments.of(5, 13, 13, 1),
                Arguments.of(5, 13, 14, 0),
                Arguments.of(0, 0, 1, 1),
                Arguments.of(1, 1, 1, 1),
                Arguments.of(10, 10, 5, 1),
                Arguments.of(10, 10, 7, 0),
                Arguments.of(10, 10, 20, 0),
                Arguments.of(0, 2_000_000_000, 1, 2_000_000_001),
                Arguments.of(0, 2_000_000_000, 2_000_000_000, 2),
                Arguments.of(1, 2_000_000_000, 2_000_000_000, 1)
        );
    }

    private static Stream<Arguments> passingCars() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 1, 1}, 5),
                Arguments.of(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}, 10),
                Arguments.of(new int[]{1, 1, 1, 1, 0, 1, 0, 0, 0}, 1)
        );
    }
}
