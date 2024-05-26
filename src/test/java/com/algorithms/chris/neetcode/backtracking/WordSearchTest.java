
package com.algorithms.chris.neetcode.backtracking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WordSearchTest {

    @ParameterizedTest
    @MethodSource("wordSearch")
    void wordSearch(char[][] board, String word, boolean expected) {
        var result = WordSearch.exist(board, word);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> wordSearch() {
        return Stream.of(
            Arguments.of(
                new char[][]{new char[]{'A', 'B', 'C', 'D'}, new char[]{'S', 'A', 'A', 'T'}, new char[]{'A', 'C', 'A', 'E'}},
                "CAT", true)
        );
    }
}
