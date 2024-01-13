package com.algorithms.chris.neetcode.heap_priority_queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LastStoneWeightTest {

    @ParameterizedTest
    @MethodSource("lastStoneWeight")
    void lastStoneWeight(int[] input, int expected) {
        var result = LastStoneWeight.lastStoneWeight(input);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> lastStoneWeight() {
        return Stream.of(Arguments.of(
                new int[]{2, 7, 4, 1, 8, 1}, 1
        ));
    }
}
