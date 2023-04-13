package com.algorithms.chris.neetcode.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinStackTest {

    @ParameterizedTest
    @MethodSource("minStack")
    void minStack(List<String> methodNames, List<Integer> args, List<Integer> expected) {
        var minStack = new MinStack();
        var result = new ArrayList<>(methodNames.size());
        for (int i = 0; i < methodNames.size(); i++) {
            if (args.get(i) != null) {
                result.add(ReflectionTestUtils.invokeMethod(minStack, methodNames.get(i), args.get(i)));
            } else {
                result.add(ReflectionTestUtils.invokeMethod(minStack, methodNames.get(i)));
            }
        }
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> minStack() {
        return Stream.of(Arguments.of(
                List.of("push", "push", "push", "getMin", "pop", "top", "getMin"),
                Arrays.asList(-2, 0, -3, null, null, null, null),
                Arrays.asList(null, null, null, -3, null, 0, -2))
        );
    }
}
