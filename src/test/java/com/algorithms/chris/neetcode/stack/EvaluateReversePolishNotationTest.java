package com.algorithms.chris.neetcode.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class EvaluateReversePolishNotationTest {

    @ParameterizedTest
    @MethodSource("evalRPN")
    void evalRPN(String[] arg, int expected) {
        var result = EvaluateReversePolishNotation.evalRPN(arg);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> evalRPN() {
        return Stream.of(
                Arguments.of(new String[]{"2", "1", "+", "3", "*"}, 9),
                Arguments.of(new String[]{"4", "13", "5", "/", "+"}, 6),
                Arguments.of(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22)
        );
    }
}
