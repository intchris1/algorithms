package com.algorithms.chris.neetcode.heap_priority_queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KthLargestTest {

    @ParameterizedTest
    @MethodSource("kthLargest")
    void kthLargest(int k, int[] nums, List<Integer> args, List<Integer> expected) {
        var kthLargest = new KthLargest(k, nums);
        var result = new ArrayList<>(args.size());
        for (Integer arg : args) {
            result.add(kthLargest.add(arg));
        }
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> kthLargest() {
        return Stream.of(Arguments.of(
                3, new int[]{4, 5, 8, 2}, List.of(3, 5, 10, 9, 4), List.of(4, 5, 5, 8, 8)
        ));
    }
}
