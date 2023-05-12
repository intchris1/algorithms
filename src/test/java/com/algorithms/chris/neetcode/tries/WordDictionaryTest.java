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

public class WordDictionaryTest {

    @ParameterizedTest
    @MethodSource("wordDictionary")
    void wordDictionary(List<String> methodNames, List<String> args, List<Boolean> expected) {
        var wordDictionary = new WordDictionary();
        var result = new ArrayList<>(methodNames.size());
        for (int i = 0; i < methodNames.size(); i++) {
            result.add(ReflectionTestUtils.invokeMethod(wordDictionary, methodNames.get(i), args.get(i)));
        }
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> wordDictionary() {
        return Stream.of(Arguments.of(
                List.of("addWord", "addWord", "addWord", "search", "search", "search", "search", "search"),
                Arrays.asList("bad", "dad", "mad", "pad", "bad", ".ad", "b..", "...."),
                Arrays.asList(null, null, null, false, true, true, true, false))
        );
    }
}
