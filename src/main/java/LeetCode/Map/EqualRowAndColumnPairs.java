package LeetCode.Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Utils.PrintUtil;

/**
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri,
 * cj) such that row ri and column cj are equal.
 *
 * A row and column pair is considered equal if they contain the same elements
 * in the same order (i.e., an equal array).
 */
public class EqualRowAndColumnPairs {
    // method 1: transpose + compare - O(n^3) time, O(n^2) space
    public int equalPairs(int[][] grid) {
        int length = grid.length;
        int[][] columnGrid = new int[length][length];
        int count = 0;

        // transpose the grid so columns become rows
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                columnGrid[j][i] = grid[i][j];
            }
        }

        // compare each row with each transposed column
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (Arrays.equals(grid[i], columnGrid[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    // method 2: HashMap approach - O(n^2) time, O(n^2) space
    public int equalPairsHashMap(int[][] grid) {
        int length = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();

        // store each row as a string key with its frequency
        for (int i = 0; i < length; i++) {
            String key = Arrays.toString(grid[i]); // convert row to string to it can be compared with other rows
            rowMap.put(key, rowMap.getOrDefault(key, 0) + 1);
        }

        int count = 0;
        // build each column as a string and check if it matches any row
        for (int j = 0; j < length; j++) {
            int[] col = new int[length];
            for (int i = 0; i < length; i++) {
                col[i] = grid[i][j];
            }
            String key = Arrays.toString(col);
            count += rowMap.getOrDefault(key, 0);
        }

        return count;
    }

    // method 3: rolling hash - O(n^2) time, O(n) space, avoids string allocation overhead
    public int equalPairsRollingHash(int[][] grid) {
        int n = grid.length;
        Map<Long, Integer> rowMap = new HashMap<>();

        // hash each row using a polynomial rolling hash
        for (int i = 0; i < n; i++) {
            long hash = 0;
            for (int j = 0; j < n; j++) {
                hash = hash * 100003 + grid[i][j]; // prime multiplier > max value to avoid collisions
            }
            rowMap.put(hash, rowMap.getOrDefault(hash, 0) + 1);
        }

        int count = 0;
        // hash each column and check against row hashes
        for (int j = 0; j < n; j++) {
            long hash = 0;
            for (int i = 0; i < n; i++) {
                hash = hash * 100003 + grid[i][j];
            }
            count += rowMap.getOrDefault(hash, 0);
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                { 3, 1, 2, 2 },
                { 1, 4, 4, 5 },
                { 2, 4, 2, 2 },
                { 2, 4, 2, 2 }
        };
        System.out.println("grid: ");
        PrintUtil.printMatrix(grid);
        // You may want to instantiate EqualRowAndColumnPairs and call equalPairs here
        EqualRowAndColumnPairs solution = new EqualRowAndColumnPairs();
        int result = solution.equalPairs(grid);
        System.out.println("Equal row and column pairs: " + result);    }
}
