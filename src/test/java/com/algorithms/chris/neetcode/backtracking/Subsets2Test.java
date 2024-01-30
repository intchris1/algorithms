
package com.algorithms.chris.neetcode.backtracking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Subsets2Test {

    @ParameterizedTest
    @MethodSource("subsets2")
    void subsets2(int[] nums, List<List<Integer>> expected) {
        var result = Subsets2.subsets2(nums);
        for (List<Integer> integers : result) {
            Collections.sort(integers);
        }
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> subsets2() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 2}, List.of(List.of(), List.of(1), List.of(1, 2),
                                List.of(1, 2, 2), List.of(2), List.of(2, 2))),
                Arguments.of(
                        new int[]{4, 4, 4, 1, 4},
                        List.of(List.of(), List.of(1), List.of(1, 4), List.of(1, 4, 4),
                                List.of(1, 4, 4, 4), List.of(1, 4, 4, 4, 4), List.of(4),
                                List.of(4, 4), List.of(4, 4, 4), List.of(4, 4, 4, 4))
                )
        );
    }
}
