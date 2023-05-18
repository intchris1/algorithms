package com.algorithms.chris.neetcode.tries;

import java.util.ArrayList;
import java.util.List;

/**
 * Найти все слова, встречающиеся на доске - буквы должны соединяться между собой только по прямым направлениям.
 * Решение:
 * 1) Создать префиксное дерево, в которое добавить индекс слова для последней буквы каждого слова.
 * 2) Для каждой буквы на доске осуществлять поиск в глубину в четырех направлениях (или меньше).
 * 3) Вести учет посещенным буквам.
 * 4) Если нашли слово, добавляем в результат и удаляем индекс слова из узла дерева.
 * <p>
 * Find all words from the list on the board. Letters can only be on sequentially adjacent cells.
 * Solution:
 * 1) Create a prefix tree, save index of each word in a node of ending letter.
 * 2) For each letter on the board go depth first search in 4 directions (or less).
 * 3) Remember visited letters.
 * 4) If a word is found, add it to result and remove its index from the node.
 */
public class FindWords {

    private static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        int indexOfWord = -1;

        void addWord(String word, int indexOfWord) {
            var cur = this;
            for (char c : word.toCharArray()) {
                var id = c - 'a';
                if (cur.next[id] == null) {
                    cur.next[id] = new TrieNode();
                }
                cur = cur.next[id];
            }
            cur.indexOfWord = indexOfWord;
        }

    }

    public static List<String> findWords(char[][] board, String[] words) {
        var root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            root.addWord(words[i], i);
        }
        var result = new ArrayList<String>();
        var visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                find(visited, root, board, i, j, result, words);
            }
        }
        return result;
    }

    private static void find(boolean[][] visited, TrieNode curr, char[][] board, int x, int y, List<String> result, String[] words) {
        if (x < 0 || y < 0 || x == board.length || y == board[0].length || visited[x][y]) {
            return;
        }
        char letter = board[x][y];
        var id = letter - 'a';
        curr = curr.next[id];
        if (curr != null) {
            visited[x][y] = true;
            if (curr.indexOfWord != -1) {
                result.add(words[curr.indexOfWord]);
                curr.indexOfWord = -1;
            }
            find(visited, curr, board, x - 1, y, result, words);
            find(visited, curr, board, x + 1, y, result, words);
            find(visited, curr, board, x, y - 1, result, words);
            find(visited, curr, board, x, y + 1, result, words);
            visited[x][y] = false;
        }
    }
}
