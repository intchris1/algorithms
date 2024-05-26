package com.algorithms.chris.neetcode.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class WordSearch {

    private static int iMax;
    private static int jMax;

    public static boolean exist(char[][] board, String word) {
        var charArray = word.toCharArray();
        iMax = board.length;
        jMax = board[0].length;
        char first = charArray[0];
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            char[] raw = board[i];
            for (int j = 0; j < raw.length; j++) {
                var current = raw[j];
                if (current == first) {
                    visited.computeIfAbsent(i, k -> new HashSet<>()).add(j);
                    var coords = getCoords(i, j);
                    boolean found = search(board, coords, charArray, 1, visited);
                    if (found) {
                        return true;
                    } else {
                        visited.get(i).remove(j);
                    }
                }
            }
        }
        return false;
    }

    private static List<int[]> getCoords(int i, int j) {
        int up1 = i - 1;
        int down1 = i + 1;
        int left1 = j - 1;
        int right1 = j + 1;
        var result = new LinkedList<int[]>();
        if (up1 >= 0) {
            result.add(new int[]{up1, j});
        }
        if (down1 < iMax) {
            result.add(new int[]{down1, j});
        }
        if (left1 >= 0) {
            result.add(new int[]{i, left1});
        }
        if (right1 < jMax) {
            result.add(new int[]{i, right1});
        }
        return result;
    }

    private static boolean search(char[][] board, List<int[]> coords,
                                  char[] word, int searchIndex,
                                  Map<Integer, Set<Integer>> visited) {
        if (searchIndex >= word.length) {
            return true;
        }
        for (int[] coord : coords) {
            int i = coord[0];
            int j = coord[1];
            var raws = visited.get(i);
            if (raws != null && raws.contains(j)) {
                continue;
            }
            char currentLetter = board[i][j];
            char neededLetter = word[searchIndex];
            if (currentLetter == neededLetter) {
                visited.computeIfAbsent(i, k -> new HashSet<>()).add(j);
                boolean found = search(board, getCoords(i, j), word, searchIndex + 1, visited);
                if (found) {
                    return true;
                } else {
                    visited.get(i).remove(j);
                }
            }
        }
        return false;
    }
}

