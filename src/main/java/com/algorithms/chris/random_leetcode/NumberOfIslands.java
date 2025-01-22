package com.algorithms.chris.random_leetcode;

/**
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * <p>
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * <p>
 * Найти количество островов.
 * Решение: любая единица, у которой сверху и слева ничего нет или 0, считается началом острова.
 * <p>
 * Find number of islands.
 * Solution: every '1' that doesn't have or have 0 in both up and left is considered the beginning of the island.
 */
class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int current = grid[i][j];
                if (current == 1 && (i - 1 < 0 || grid[i - 1][j] == 0) && (j - 1 < 0 || grid[i][j - 1] == 0)) {
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
}