package com.algorithms.chris.neetcode.tries;

/**
 * Создать дерево префиксов с возможностью проверки, было ли вставлено это слово или начинаючееся на префикс слово.
 * Хранить ноды в массиве, каждая нода - одна буква с флагом, является ли она концом слова.
 * <p>
 * Create a trie that can check if the exact word or the word starting with given prefix was inserted.
 * Store nodes in an array, each node - one letter with a flag indicating if it is the end of the word.
 */
public class Trie {

    private final TrieNode trie = new TrieNode();

    public Trie() {

    }

    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isTheEnd = false;

    }

    public void insert(String word) {
        TrieNode next = trie;
        for (char c : word.toCharArray()) {
            var id = c - 'a';
            var newMap = next.next[id];
            if (newMap == null) {
                newMap = new TrieNode();
                next.next[id] = newMap;
            }
            next = newMap;
        }
        next.isTheEnd = true;
    }

    public boolean search(String word) {
        TrieNode next = trie;
        for (char c : word.toCharArray()) {
            var id = c - 'a';
            next = next.next[id];
            if (next == null) {
                return false;
            }
        }
        return next.isTheEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode next = trie;
        for (char c : prefix.toCharArray()) {
            var id = c - 'a';
            next = next.next[id];
            if (next == null) {
                return false;
            }
        }
        return true;
    }
}
