
package com.algorithms.chris.neetcode.backtracking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationSum2Test {

    @ParameterizedTest
    @MethodSource("combinationSum2")
    void combinationSum2(int[] nums, int target, List<List<Integer>> expected) {
        var result = CombinationSum2.combinationSum2(nums, target);
        for (List<Integer> integers : result) {
            Collections.sort(integers);
        }
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> combinationSum2() {
        return Stream.of(
                Arguments.of(
                        new int[]{10, 1, 2, 7, 6, 1, 5}, 8,
                        List.of(
                                List.of(1, 1, 6),
                                List.of(1, 2, 5),
                                List.of(1, 7),
                                List.of(2, 6)
                        )),
                Arguments.of(
                        new int[]{2, 5, 2, 1, 2}, 5, List.of(List.of(1, 2, 2), List.of(5))
                ));
    }
}
