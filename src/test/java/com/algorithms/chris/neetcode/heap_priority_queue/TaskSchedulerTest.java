package com.algorithms.chris.neetcode.heap_priority_queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TaskSchedulerTest {

    @ParameterizedTest
    @MethodSource("taskScheduler")
    void taskScheduler(char[] input, int n, int expected) {
        var result = TaskScheduler.leastInterval(input, n);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> taskScheduler() {
        return Stream.of(
                Arguments.of(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2, 8),
                Arguments.of(new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C','C', 'C', 'D', 'D', 'D'}, 2, 12),
                Arguments.of(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0, 6),
                Arguments.of(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2, 16)
        );
    }
}
