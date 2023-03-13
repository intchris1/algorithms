package com.algorithms.chris.neetcode.arrrays_hashing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TopKFrequentTest {

    @ParameterizedTest
    @MethodSource("topKFrequent")
    void topKFrequent(int[] nums, int k, int[] expected) {
        var result = TopKFrequent.topKFrequent(nums, k);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> topKFrequent() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{1}, 1, new int[]{1})
        );
    }
}
