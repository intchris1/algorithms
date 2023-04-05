package com.algorithms.chris.neetcode.binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TimeMapTest {

    @ParameterizedTest
    @MethodSource("slidingWindowMaximum")
    void slidingWindowMaximum(List<String> methodNames, List<List<Object>> args, List<Integer> expected) {
        var timeMap = new TimeMap();
        var result = new ArrayList<>(methodNames.size());
        for (int i = 0; i < methodNames.size(); i++) {
            result.add(ReflectionTestUtils.invokeMethod(timeMap, methodNames.get(i), args.get(i).toArray()));
        }
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> slidingWindowMaximum() {
        return Stream.of(Arguments.of(
                List.of("set", "get", "get", "set", "get", "get"),
                Arrays.asList(List.of("foo", "bar", 1), List.of("foo", 1),
                        List.of("foo", 3), List.of("foo", "bar2", 4),
                        List.of("foo", 4), List.of("foo", 5)),
                Arrays.asList(null, "bar", "bar", null, "bar2", "bar2")
        ));
    }
}
