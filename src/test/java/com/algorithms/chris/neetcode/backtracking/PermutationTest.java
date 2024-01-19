
package com.algorithms.chris.neetcode.backtracking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PermutationTest {

    @ParameterizedTest
    @MethodSource("permutation")
    void permutation(int[] nums, List<List<Integer>> expected) {
        var result = Permutation.permute(nums);
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> permutation() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 6, 2},
                        List.of(List.of(5, 4, 6, 2), List.of(5, 4, 2, 6), List.of(5, 6, 4, 2), List.of(5, 6, 2, 4), List.of(5, 2, 4, 6), List.of(5, 2, 6, 4), List.of(4, 5, 6, 2), List.of(4, 5, 2, 6), List.of(4, 6, 5, 2), List.of(4, 6, 2, 5), List.of(4, 2, 5, 6), List.of(4, 2, 6, 5), List.of(6, 5, 4, 2), List.of(6, 5, 2, 4), List.of(6, 4, 5, 2), List.of(6, 4, 2, 5), List.of(6, 2, 5, 4), List.of(6, 2, 4, 5), List.of(2, 5, 4, 6), List.of(2, 5, 6, 4), List.of(2, 4, 5, 6), List.of(2, 4, 6, 5), List.of(2, 6, 5, 4), List.of(2, 6, 4, 5))
                ),
                Arguments.of(
                        new int[]{1, 2, 3}, List.of(List.of(1, 2, 3), List.of(1, 3, 2),
                                List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1))),
                Arguments.of(
                        new int[]{0, 1}, List.of(List.of(1, 0), List.of(0, 1))
                ),
                Arguments.of(
                        new int[]{1}, List.of(List.of(1))
                ));
    }
}
