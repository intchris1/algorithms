package com.algorithms.chris.neetcode.linked_list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindTheDuplicateNumberTest {

    @ParameterizedTest
    @MethodSource("findTheDuplicate")
    void findTheDuplicate(int[] arg1, int expected) {
        var result = FindTheDuplicateNumber.findDuplicate(arg1);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> findTheDuplicate() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 2, 2}, 2),
                Arguments.of(new int[]{3, 1, 3, 4, 2}, 3),
                Arguments.of(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1}, 9)
        );
    }
}
