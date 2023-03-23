package com.algorithms.chris.neetcode.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateParenthesesTest {

    @ParameterizedTest
    @MethodSource("generateParentheses")
    void generateParentheses(int arg, List<String> expected) {
        var result = GenerateParentheses.generateParenthesis(arg);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> generateParentheses() {
        return Stream.of(
                Arguments.of(3, List.of("((()))", "(()())", "(())()", "()(())", "()()()")),
                Arguments.of(1, List.of("()"))
        );
    }
}
