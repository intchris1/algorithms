package com.algorithms.chris.neetcode.arrrays_hashing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GroupAnagramsTest {

    @ParameterizedTest
    @MethodSource("groupAnagrams")
    void groupAnagrams(String[] strs, List<List<String>> expected) {
        var result = GroupAnagrams.groupAnagrams(strs);
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> groupAnagrams() {
        return Stream.of(
                Arguments.of(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                        List.of(List.of("bat"), List.of("tan", "nat"), List.of("eat",  "tea", "ate"))),
                Arguments.of(new String[]{""}, List.of(List.of(""))),
                Arguments.of(new String[]{"a"}, List.of(List.of("a")))
        );
    }
}
