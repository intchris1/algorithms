
package com.algorithms.chris.neetcode.heap_priority_queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MedianFinderTest {

    @ParameterizedTest
    @MethodSource("medianFinder")
    void medianFinder(List<String> methodNames, List<Integer> args, List<Integer> expected) {
        var medianFinder = new MedianFinder();
        var result = new ArrayList<>(methodNames.size());
        for (int i = 0; i < methodNames.size(); i++) {
            if (args.get(i) != null) {
                result.add(ReflectionTestUtils.invokeMethod(medianFinder, methodNames.get(i), args.get(i)));
            } else {
                result.add(ReflectionTestUtils.invokeMethod(medianFinder, methodNames.get(i)));
            }
        }
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> medianFinder() {
        return Stream.of(
                Arguments.of(
                        List.of("addNum", "addNum", "findMedian", "addNum", "findMedian"),
                        Arrays.asList(1, 2, null, 3, null),
                        Arrays.asList(null, null, 1.5, null, 2.0)),
                Arguments.of(
                        List.of("addNum", "addNum", "addNum", "addNum", "addNum", "findMedian", "addNum", "findMedian"),
                        Arrays.asList(1, 2, 3, 4, 5, null, 3, null),
                        Arrays.asList(null, null, null, null, null, 3.0, null, 3.0)
                ),
                Arguments.of(
                        List.of("addNum", "findMedian"),
                        Arrays.asList(1, null),
                        Arrays.asList(null, 1.0)
                ),
                Arguments.of(
                        List.of("addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian"),
                        Arrays.asList(6, null, 10, null, 2, null, 6, null, 5, null, 0, null, 6, null, 3, null, 1, null, 0, null, 0, null),
                        Arrays.asList(null, 6.00000, null, 8.00000, null, 6.00000, null, 6.00000, null, 6.00000, null, 5.50000, null, 6.00000, null, 5.50000, null, 5.00000, null, 4.00000, null, 3.00000)
                ));
    }
}
