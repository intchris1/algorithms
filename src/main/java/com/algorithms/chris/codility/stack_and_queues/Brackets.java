package com.algorithms.chris.codility.stack_and_queues;

import java.util.ArrayDeque;
import java.util.Map;

/**
 * Строка содержит (){}[] скобки
 * Нужно вернуть 1, если все скобки правильно открываются и закрываются, иначе 0
 * Используется stack
 */
public class Brackets {

    public static int solution(String S) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> matches = Map.of('{', '}', '[', ']', '(', ')');
        for (char c : S.toCharArray()) {
            if (matches.containsKey(c)) {
                stack.push(c);
            } else {
                var lastOpen = stack.poll();
                if (lastOpen == null || matches.get(lastOpen) != c) {
                    return 0;
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
