package com.algorithms.chris.neetcode.tries;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindWordsTest {

    @ParameterizedTest
    @MethodSource("findWords")
    void findWords(char[][] arg1, String[] arg2, List<String> expected) {
        var result = FindWords.findWords(arg1, arg2);
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> findWords() {
        return Stream.of(
                Arguments.of(new char[][]{
                        new char[]{'o', 'a', 'a', 'n'}, new char[]{'e', 't', 'a', 'e'}, new char[]{'i', 'h', 'k', 'r'}, new char[]{'i', 'f', 'l', 'v'}
                }, new String[]{"oath", "pea", "eat", "rain", "oatht", "oathka", "a"}, List.of("eat", "oath", "oathka", "a")),
                Arguments.of(new char[][]{
                                new char[]{'a', 'b'}, new char[]{'c', 'd'}
                        }, new String[]{"abcb"}, List.of()
                ),
                Arguments.of(new char[][]{
                        new char[]{'o', 'a', 'a', 'n'}, new char[]{'e', 't', 'a', 'e'}, new char[]{'i', 'h', 'k', 'r'}, new char[]{'i', 'f', 'l', 'v'}
                }, new String[]{"oath", "pea", "eat", "rain", "hklf", "hf"}, List.of("oath", "eat", "hklf", "hf")),
                Arguments.of(new char[][]{
                        new char[]{'a', 'b', 'c'}, new char[]{'a', 'e', 'd'}, new char[]{'a', 'f', 'g'}
                }, new String[]{"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"}, List.of("abcdefg", "befa", "eaabcdgfa", "gfedcbaaa"))
        );
    }
}
