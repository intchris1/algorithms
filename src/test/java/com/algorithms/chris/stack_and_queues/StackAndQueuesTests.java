package com.algorithms.chris.stack_and_queues;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StackAndQueuesTests {

    @ParameterizedTest
    @MethodSource("brackets")
    void brackets(String input, int expected) {
        final int result = Brackets.solution(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("fish")
    void fish(int[] size, int[] direction, int expected) {
        int result = Fish.solution(size, direction);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("nesting")
    void nesting(String S, int expected) {
        int result = Nesting.solution(S);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("stoneWall")
    void stoneWall(int[] input, int expected) {
        int result = StoneWall.solution(input);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> stoneWall() {
        return Stream.of(
                Arguments.of(new int[]{8, 7, 7, 8, 9, 4, 5, 8, 8}, 7),
                Arguments.of(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}, 7),
                Arguments.of(new int[]{8, 8, 8, 8, 1}, 2),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 2, 1}, 2),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 3, 2}, 3),
                Arguments.of(new int[]{8, 8, 8, 8, 1, 8}, 3),
                Arguments.of(new int[]{Integer.MAX_VALUE}, 1)
        );
    }

    private static Stream<Arguments> nesting() {
        return Stream.of(
                Arguments.of("(()(())())", 1),
                Arguments.of("())", 0),
                Arguments.of("((((", 0),
                Arguments.of("))))", 0),
                Arguments.of("", 1)
        );
    }

    private static Stream<Arguments> fish() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}, 2),
                Arguments.of(new int[]{5, 6, 7, 8, 9, 10}, new int[]{0, 1, 1, 1, 1, 0}, 2),
                Arguments.of(new int[]{10, 9, 9, 9, 9, 9}, new int[]{1, 0, 0, 0, 0, 0}, 1),
                Arguments.of(new int[]{0, 0, 0}, new int[]{0, 0, 0}, 3),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 1, 1, 1, 0}, 1),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, new int[]{1, 0, 0, 0, 0}, 1),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 0, 0, 0, 0}, 4),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 1, 1, 1, 1}, 5)
        );
    }

    private static Stream<Arguments> brackets() {
        return Stream.of(
                Arguments.of("{[()()]}", 1),
                Arguments.of("([)()]", 0),
                Arguments.of("", 1),
                Arguments.of("(((((((}", 0),
                Arguments.of("(()}", 0),
                Arguments.of("))))))", 0),
                Arguments.of("(((((", 0)
        );
    }
}
