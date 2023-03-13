package com.algorithms.chris.neetcode.arrrays_hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Проверить валидность судоку.
 *
 * Check sudoku validity.
 */
public class ValidSudoku {

    public static boolean validSudoku(char[][] board) {
        var cells = new ArrayList<List<HashSet<Character>>>(3);
        for (int i = 0; i < board.length; i++) {
            var column = new HashSet<Character>(9);
            var row = new HashSet<Character>(9);
            for (int j = 0; j < board[i].length; j++) {
                var currentFromRow = board[i][j];
                if (i == 0 && j % 3 == 0) {
                    cells.add(new ArrayList<>(3));
                }
                if (i % 3 == 0 && j % 3 == 0) {
                    cells.get(j / 3).add(new HashSet<>(9));
                }
                if (currentFromRow != '.') {
                    var newElementFromRow = row.add(currentFromRow);
                    if (!newElementFromRow) return false;
                    var cellForRowElement = cells.get(j / 3).get(i / 3);
                    var newForCell = cellForRowElement.add(currentFromRow);
                    if (!newForCell) return false;
                }
                var currentFromColumn = board[j][i];
                if (currentFromColumn != '.') {
                    var newElementFromColumn = column.add(currentFromColumn);
                    if (!newElementFromColumn) return false;
                }

            }
        }
        return true;
    }
}
