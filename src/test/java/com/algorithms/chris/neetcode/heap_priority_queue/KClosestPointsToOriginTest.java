package com.algorithms.chris.neetcode.heap_priority_queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KClosestPointsToOriginTest {

    @ParameterizedTest
    @MethodSource("kClosestPointsToOrigin")
    void kClosestPointsToOrigin(int[][] input, int k, int[][] expected) {
        var result = KClosestPointsToOrigin.kClosest(input, k);
        assertThat(Arrays.asList(result)).containsExactlyInAnyOrderElementsOf(Arrays.asList(expected));
    }

    private static Stream<Arguments> kClosestPointsToOrigin() {
        return Stream.of(
                Arguments.of(
                        new int[][]{new int[]{1, 3}, new int[]{-2, 2}}, 1, new int[][]{new int[]{-2, 2}}),
                Arguments.of(
                        new int[][]{new int[]{3, 3}, new int[]{5, -1}, new int[]{-2, 4}}, 2,
                        new int[][]{new int[]{3, 3}, new int[]{-2, 4}}
                )
        );
    }
}
