package com.algorithms.chris.counting_elements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountingElementsTests {

    @ParameterizedTest
    @MethodSource("frogRiverOne")
    void frogRiverOne(int target, int[] arg, int expected) {
        final int result = FrogRiverOne.solution(target, arg);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("permCheck")
    void permCheck(int[] arg, int expected) {
        final int result = PermCheck.solution(arg);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("maxCounters")
    void maxCounters(int N, int[] arg, int[] expected) {
        final int[] result = MaxCounters.solution(N, arg);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("missingInteger")
    void missingInteger(int[] arg, int expected) {
        final int result = MissingInteger.solution(arg);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> missingInteger() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 6, 4, 1, 2}, 5),
                Arguments.of(new int[]{1, 2, 3}, 4),
                Arguments.of(new int[]{-1, -3}, 1),
                Arguments.of(new int[]{-1000000, 0}, 1),
                Arguments.of(new int[]{-1000000, 1000000}, 1),
                Arguments.of(new int[]{-1000000, 0, 1, 1, -1}, 2),
                Arguments.of(new int[]{-1000000, 0, 1, 4, -4, -1, 2}, 3)
        );
    }

    private static Stream<Arguments> maxCounters() {
        return Stream.of(
                Arguments.of(5, new int[]{3, 4, 4, 6, 1, 4, 4}, new int[]{3, 2, 2, 4, 2}),
                Arguments.of(1, new int[]{1, 2}, new int[]{1})
        );
    }

    private static Stream<Arguments> permCheck() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 1, 4, 2}, 0),
                Arguments.of(new int[]{1, 3, 4, 2}, 1),
                Arguments.of(new int[]{1, 3, 4, 2, 1}, 0),
                Arguments.of(new int[]{2, 1}, 1),
                Arguments.of(new int[]{3, 1}, 0),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{2}, 0),
                Arguments.of(new int[]{5, 1}, 0),
                Arguments.of(new int[]{1, 1}, 0)
        );
    }

    private static Stream<Arguments> frogRiverOne() {
        return Stream.of(
                Arguments.of(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}, 6),
                Arguments.of(5, new int[]{1, 3, 1, 4, 4, 3, 5, 4, 2}, 8),
                Arguments.of(5, new int[]{0}, -1),
                Arguments.of(1, new int[]{}, -1),
                Arguments.of(5, new int[]{5, 1}, -1),
                Arguments.of(1, new int[]{1, 1}, 0)
        );
    }
}
