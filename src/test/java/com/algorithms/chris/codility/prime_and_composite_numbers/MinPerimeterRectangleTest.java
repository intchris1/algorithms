package com.algorithms.chris.codility.prime_and_composite_numbers;

import com.algorithms.chris.codility.prime_and_composite_numbers.MinPerimeterRectangle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinPerimeterRectangleTest {

    @ParameterizedTest
    @MethodSource("minPerimeterRectangle")
    void minPerimeterRectangle(int arg, int expected) {
        final int result = MinPerimeterRectangle.solution(arg);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> minPerimeterRectangle() {
        return Stream.of(
                Arguments.of(5, 12),
                Arguments.of(24, 20),
                Arguments.of(Integer.MAX_VALUE, 0),
                Arguments.of(Integer.MAX_VALUE - 1, 185894),
                Arguments.of(25, 20),
                Arguments.of(0, 0),
                Arguments.of(292992290, 58598478)
        );
    }
}