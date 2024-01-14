
package com.algorithms.chris.neetcode.backtracking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SubsetsTest {

    @ParameterizedTest
    @MethodSource("subsets")
    void subsets(int[] nums, List<List<Integer>> expected) {
        var result = Subsets.subsets(nums);
        for (List<Integer> integers : result) {
            Collections.sort(integers);
        }
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> subsets() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3}, List.of(List.of(), List.of(1), List.of(2),
                                List.of(1, 2), List.of(3), List.of(1, 3), List.of(2, 3), List.of(1, 2, 3))),
                Arguments.of(
                        new int[]{0}, List.of(List.of(), List.of(0))
                ),
                Arguments.of(
                        new int[]{3, 2, 4, 1},
                        List.of(List.of(), List.of(3), List.of(2), List.of(2, 3), List.of(4),
                                List.of(3, 4), List.of(2, 4), List.of(2, 3, 4), List.of(1), List.of(1, 3), List.of(1, 2), List.of(1, 2, 3), List.of(1, 4), List.of(1, 3, 4), List.of(1, 2, 4), List.of(1, 2, 3, 4))
                ));
    }
}
