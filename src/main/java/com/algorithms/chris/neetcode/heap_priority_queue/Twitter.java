package com.algorithms.chris.neetcode.heap_priority_queue;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Написать твиттер. Пользователь может подписаться на другого пользователя или отписаться от него. Пользователь может получить новостную ленту.
 * В ней должны быть 10 свежайших постов от пользователей, на которых подписан запрашивающий, включая посты от самого себя.
 * Решение:
 * Хранить пользователей, на которых подписан пользователь, в мапе с сетами.
 * Хранить посты по идентификатору в мапе со связными списками.
 * При сборке новостной ленты использовать приоритетную очередь.
 * <p>
 * Design twitter. A user can follow/unfollow other users. A user can get a news feed, which should contain 10 newest posts from followees,
 * including the user himself.
 * Solution:
 * Store users and his followees in a hash map with hash sets.
 * Store posts by user id in a hash map with linked lists.
 * When getting a news feed, use a priority queue.
 */
class Twitter {

    public static final Comparator<Post> COMPARE_TIME = Comparator
            .comparingLong((Post it) -> it.id);
    private final Map<Integer, Set<Integer>> followeesById = new HashMap<>();
    private final Map<Integer, LinkedList<Post>> postsById = new HashMap<>();
    private int idIncrementer = 0;

    private static class Post {
        final int tweetId;
        final int id;

        private Post(int tweetId, int id) {
            this.tweetId = tweetId;
            this.id = id;
        }
    }

    public void postTweet(int userId, int tweetId) {
        var followees = followeesById.computeIfAbsent(userId, k -> new HashSet<>());
        followees.add(userId);
        var post = new Post(tweetId, ++idIncrementer);
        var posts = postsById.computeIfAbsent(userId, k -> new LinkedList<>());
        posts.addFirst(post);
        if (posts.size() > 10) {
            posts.removeLast();
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        var followees = followeesById.get(userId);
        if (followees == null) {
            return Collections.emptyList();
        }
        var feed = new PriorityQueue<>(COMPARE_TIME);
        for (Integer followee : followees) {
            var postsByFollowee = postsById.get(followee);
            if (postsByFollowee != null) {
                for (Post post : postsByFollowee) {
                    if (feed.size() == 10) {
                        var oldestId = feed.peek().id;
                        if (post.id > oldestId) {
                            feed.add(post);
                            feed.remove();
                        } else {
                            break;
                        }
                    } else {
                        feed.add(post);
                    }
                }
            }
        }
        var list = new LinkedList<Integer>();
        while (feed.peek() != null) {
            list.addFirst(feed.remove().tweetId);
        }
        return list;
    }

    public void follow(int followerId, int followeeId) {
        followeesById.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followeesById.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
    }
}