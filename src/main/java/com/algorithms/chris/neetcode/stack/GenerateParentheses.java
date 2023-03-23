package com.algorithms.chris.neetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Сгенерировать все возможные валидные комбинации скобок, n - количество закрытых/открытых скобок
 * Решение:
 * Добавлять открытую скобку, если количество открытых < n
 * Добавлять закрытую скобку, если количество закрытых < открытых
 * Полученная комбинация валидная, если количество закрытых == количеству открытых == n
 * <p>
 * Generate all possible valid pairs of parentheses, n - is a count of closed/open parenthesis
 * Solution:
 * Only add an open parenthesis if open < n
 * Only add a closing parenthesis if closed < open
 * Combination is valid if closed == open == n
 */
public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recurse(res, 0, 0, "", n);
        return res;
    }

    public static void recurse(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        if (left < n) {
            recurse(res, left + 1, right, s + "(", n);
        }
        if (right < left) {
            recurse(res, left, right + 1, s + ")", n);
        }
    }
}
