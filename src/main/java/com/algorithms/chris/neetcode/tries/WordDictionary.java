package com.algorithms.chris.neetcode.tries;

/**
 * Сделать функционал по поиску слов, если в слове точка - подойдет любой символ.
 * Хранить ноды для каждой буквы. Маркировать концы слов. Для точек использовать поиск в глубину - проходиться по каждой детской ноде.
 * <p>
 * Create a functionality of searching words. If the word contains '.' - any character matches.
 * Store nodes for each letter. Mark the end of a word. For dots use a depth first search - go to every child node.
 */
public class WordDictionary {

    private final TrieNode trie = new TrieNode();

    public WordDictionary() {

    }

    private static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isTheEnd = false;

    }

    public void addWord(String word) {
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
        return search(trie, word.toCharArray(), 0);

    }

    private boolean search(TrieNode node, char[] word, int start) {
        TrieNode next = node;
        for (int i = start; i < word.length; i++) {
            var c = word[i];
            if (c == '.') {
                for (TrieNode trieNode : next.next) {
                    if (trieNode != null) {
                        boolean found = search(trieNode, word, i + 1);
                        if (found) {
                            return true;
                        }
                    }
                }
                return false;
            }
            var id = c - 'a';
            next = next.next[id];
            if (next == null) {
                return false;
            }
        }
        return next.isTheEnd;
    }
}