package com.algorithms.chris.neetcode.linked_list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LRUCacheTest {

    @ParameterizedTest
    @MethodSource("LRUCache")
    void LRUCache(List<String> methodNames, List<Object[]> args, List<Integer> expected, int size) {
        var lruCache = new LRUCache(size);
        var result = new ArrayList<>(methodNames.size());
        for (int i = 0; i < methodNames.size(); i++) {
            if (args.get(i) != null) {
                var arg = args.get(i);
                result.add(ReflectionTestUtils.invokeMethod(lruCache, methodNames.get(i), arg));
            } else {
                result.add(ReflectionTestUtils.invokeMethod(lruCache, methodNames.get(i)));
            }
        }
        assertThat(result).isEqualTo(expected);
    }


    private static Stream<Arguments> LRUCache() {
        return Stream.of(Arguments.of(
                        List.of("put", "put", "get", "put", "get", "put", "get", "get", "get"),
                        Arrays.asList(args(1, 1), args(2, 2), args(1),
                                args(3, 3), args(2), args(4, 4),
                                args(1), args(3), args(4)),
                        Arrays.asList(null, null, 1, null, -1, null, -1, 3, 4), 2),
                Arguments.of(
                        List.of("put", "put", "put", "put", "get", "get"),
                        Arrays.asList(args(2, 1), args(1, 1), args(2, 3),
                                args(4, 1), args(1), args(2)),
                        Arrays.asList(null, null, null, null, -1, 3), 2),
                Arguments.of(
                        List.of("put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get", "put", "put", "put", "get", "put", "get", "get", "get", "get", "put", "put", "get", "get", "get", "put", "put", "get", "put", "get", "put", "get", "get", "get", "put", "put", "put", "get", "put", "get", "get", "put", "put", "get", "put", "put", "put", "put", "get", "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put", "get", "put", "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "put", "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put"),
                        Arrays.asList(args(10, 13), args(3, 17), args(6, 11), args(10, 5), args(9, 10), args(13), args(2, 19), args(2), args(3), args(5, 25), args(8), args(9, 22), args(5, 5), args(1, 30), args(11), args(9, 12), args(7), args(5), args(8), args(9), args(4, 30), args(9, 3), args(9), args(10), args(10), args(6, 14), args(3, 1), args(3), args(10, 11), args(8), args(2, 14), args(1), args(5), args(4), args(11, 4), args(12, 24), args(5, 18), args(13), args(7, 23), args(8), args(12), args(3, 27), args(2, 12), args(5), args(2, 9), args(13, 4), args(8, 18), args(1, 7), args(6), args(9, 29), args(8, 21), args(5), args(6, 30), args(1, 12), args(10), args(4, 15), args(7, 22), args(11, 26), args(8, 17), args(9, 29), args(5), args(3, 4), args(11, 30), args(12), args(4, 29), args(3), args(9), args(6), args(3, 4), args(1), args(10), args(3, 29), args(10, 28), args(1, 20), args(11, 13), args(3), args(3, 12), args(3, 8), args(10, 9), args(3, 26), args(8), args(7), args(5), args(13, 17), args(2, 27), args(11, 15), args(12), args(9, 19), args(2, 15), args(3, 16), args(1), args(12, 17), args(9, 1), args(6, 19), args(4), args(5), args(5), args(8, 1), args(11, 7), args(5, 2), args(9, 28), args(1), args(2, 2), args(7, 4), args(4, 22), args(7, 24), args(9, 26), args(13, 28), args(11, 26)),
                        Arrays.asList(null, null, null, null, null, -1, null, 19, 17, null, -1, null, null, null, -1, null, -1, 5, -1, 12, null, null, 3, 5, 5, null, null, 1, null, -1, null, 30, 5, 30, null, null, null, -1, null, -1, 24, null, null, 18, null, null, null, null, -1, null, null, 18, null, null, -1, null, null, null, null, null, 18, null, null, -1, null, 4, 29, 30, null, 12, -1, null, null, null, null, 29, null, null, null, null, 17, 22, 18, null, null, null, -1, null, null, null, 20, null, null, null, -1, 18, 18, null, null, null, null, 20, null, null, null, null, null, null, null), 10)
        );
    }


    private static Object[] args(Object... objects) {
        return objects;
    }

}
