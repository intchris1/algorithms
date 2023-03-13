package com.algorithms.chris.neetcode.arrrays_hashing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTest {

    @ParameterizedTest
    @MethodSource("twoSum")
    void twoSum(int[] nums, int target, int[] expected) {
        var result = TwoSum.twoSum(nums, target);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> twoSum() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }
}
