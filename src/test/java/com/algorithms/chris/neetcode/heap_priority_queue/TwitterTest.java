package com.algorithms.chris.neetcode.heap_priority_queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.algorithms.chris.util.TestUtil.args;
import static org.assertj.core.api.Assertions.assertThat;

class TwitterTest {

    @ParameterizedTest
    @MethodSource("twitter")
    void twitter(List<String> methodNames, List<Object[]> args, List<Integer> expected) {
        var twitter = new Twitter();
        var result = new ArrayList<>(methodNames.size());
        for (int i = 0; i < methodNames.size(); i++) {
            if (args.get(i) != null) {
                Object[] arg = args.get(i);
                result.add(ReflectionTestUtils.invokeMethod(twitter, methodNames.get(i), arg));
            } else {
                result.add(ReflectionTestUtils.invokeMethod(twitter, methodNames.get(i)));
            }
        }
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> twitter() {
        return Stream.of(
                Arguments.of(
                        List.of("postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"),
                        List.of(new Object[]{1, 5}, new Object[]{1}, new Object[]{1, 2}, new Object[]{2, 6}, new Object[]{1},
                                new Object[]{1, 2}, new Object[]{1}),
                        Arrays.asList(null, List.of(5), null, null, List.of(6, 5), null, List.of(5))),
                Arguments.of(
                        List.of("postTweet", "postTweet", "unfollow", "follow", "getNewsFeed"),
                        Arrays.asList(new Object[]{1, 4}, new Object[]{2, 5}, new Object[]{1, 2}, new Object[]{1, 2}, new Object[]{1}),
                        Arrays.asList(null, null, null, null, List.of(5, 4))
                ),
                Arguments.of(
                        List.of("postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "getNewsFeed", "follow", "getNewsFeed"),
                        List.of(args(2, 5), args(1, 3), args(1, 101),
                                args(2, 13), args(2, 10), args(1, 2), args(2, 94),
                                args(2, 505), args(1, 333), args(1, 22), args(2), args(2, 1), args(2)),
                        Arrays.asList(null, null, null, null, null, null, null, null, null, null, List.of(505, 94, 10, 13, 5), null,
                                List.of(22, 333, 505, 94, 2, 10, 13, 101, 3, 5))
                ),
                Arguments.of(
                        List.of("postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "getNewsFeed", "follow", "getNewsFeed", "unfollow", "getNewsFeed"),
                        List.of(args(1, 5), args(2, 3), args(1, 101), args(2, 13), args(2, 10), args(1, 2), args(1, 94), args(2, 505), args(1, 333), args(2, 22), args(1, 11), args(1, 205), args(2, 203), args(1, 201), args(2, 213), args(1, 200), args(2, 202), args(1, 204), args(2, 208), args(2, 233), args(1, 222), args(2, 211), args(1), args(1, 2), args(1), args(1, 2), args(1)),
                        Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, List.of(222, 204, 200, 201, 205, 11, 333, 94, 2, 101), null, List.of(211, 222, 233, 208, 204, 202, 200, 213, 201, 203), null, List.of(222, 204, 200, 201, 205, 11, 333, 94, 2, 101))
                )
        );
    }
}
