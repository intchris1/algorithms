
package com.algorithms.chris.neetcode.backtracking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationSumTest {

    @ParameterizedTest
    @MethodSource("combinationSum")
    void combinationSum(int[] nums, int target, List<List<Integer>> expected) {
        var result = CombinationSum.combinationSum(nums, target);
        for (List<Integer> integers : result) {
            Collections.sort(integers);
        }
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> combinationSum() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 3, 6, 7}, 7, List.of(List.of(2, 2, 3), List.of(7))),
                Arguments.of(
                        new int[]{2}, 1, List.of()
                ),
                Arguments.of(
                        new int[]{2, 3, 5}, 8,
                        List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5))
                ));
    }
}
