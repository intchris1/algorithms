package com.algorithms.chris.neetcode.stack;

import java.util.LinkedList;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        var stack = new LinkedList<Integer>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    stack.add(stack.removeLast() + stack.removeLast());
                    break;
                }
                case "-": {
                    var a = stack.removeLast();
                    var b = stack.removeLast();
                    var result = b - a;
                    stack.add(result);
                    break;
                }
                case "*": {
                    stack.add(stack.removeLast() * stack.removeLast());
                    break;
                }
                case "/": {
                    var a = stack.removeLast();
                    var b = stack.removeLast();
                    var result = b / a;
                    stack.add(result);
                    break;
                }
                default:
                    stack.add(Integer.parseInt(token));
                    break;
            }
        }
        return stack.removeLast();
    }
}
