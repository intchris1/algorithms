package com.algorithms.chris.stack_and_queues;

/**
 * Строка состоит из "(" и ")". Нужно вернуть 1, если все скобки правильно открываются и закрываются, и 0, если нет.
 * Решение: вести каунтер, в случае открывающейся скобки прибавлять 1, в случае иначе отнимать 1.
 * Если значение каунтера стало отрицательным, вернуть 0.
 * (Дополнительная оптимизация - если каунтер больше, чем количество оставшихся скобок, можно вернуть 0, нет смысла проверять дальше)
 * (Дополнительная оптимизация - если длина строки нечетная, вернуть 0)
 * Проверить каунтер в конце - если все скобки закрыты, значение должно быть 0, тогда вернуть 1, иначе 0.
 * <p>
 * String S consists of "(" and ")". The function should return 1 if all the brackets are properly nested, 0 otherwise.
 * Solution - introduce a counter. Increment it after an open bracket, decrement after a closing bracket.
 * If the counter went below zero, return 0.
 * (Optimization - if the counter is greater than string length, return 0 - it's clear that there are not enough closing brackets on the right)
 * (Optimization - if string length is odd, return 0)
 * Check counter in the end - if all the brackets are properly nested, the counter should be zero, the functions returns 1, otherwise 0;
 */
public class Nesting {

    public static int solution(String S) {
        if (S.length() % 2 > 0) return 0;
        long counter = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                counter++;
            } else if (c == ')') {
                counter--;
            }
            if (counter < 0 || counter > S.length()) {
                return 0;
            }
        }
        return counter == 0 ? 1 : 0;
    }
}
