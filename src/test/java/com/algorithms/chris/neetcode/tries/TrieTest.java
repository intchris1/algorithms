package com.algorithms.chris.neetcode.tries;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TrieTest {

    @ParameterizedTest
    @MethodSource("tries")
    void tries(List<String> methodNames, List<String> args, List<Boolean> expected) {
        var trie = new Trie();
        var result = new ArrayList<>(methodNames.size());
        for (int i = 0; i < methodNames.size(); i++) {
            result.add(ReflectionTestUtils.invokeMethod(trie, methodNames.get(i), args.get(i)));
        }
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> tries() {
        return Stream.of(Arguments.of(
                List.of("insert", "search", "search", "startsWith", "insert", "search"),
                Arrays.asList("apple", "apple", "app", "app", "app", "app"),
                Arrays.asList(null, true, false, true, null, true))
        );
    }
}
