package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class DesignTicTacToe {

    int gridSize;
    String[][] grid;
    Map<Integer, String> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public DesignTicTacToe(int n) {
        gridSize = n;
        grid = new String[n][n];
        // reduce loop of winCheck Method;
        map.put(1, "X");
        map.put(2, "O");
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */


    public int move(int row, int col, int player) {
        grid[row][col] = player == 1 ? "X" : "O"; // if player 1 then put "X", else put "O"
        return winCheck(grid,player);
    }

    public int winCheck(String[][] grid, int player) {
        // check each row,column and diagonal left to right
        int countRow = 0, countCol = 0, countLeftDia = 0 , countRightDia = 0;
        for (int i = 0; i < gridSize; i++) {
            if (grid[i][i] == map.get(player)) countLeftDia++;
            if (grid[i][gridSize-1-i] == map.get(player)) countRightDia++;
            countRow = 0;
            countCol = 0;
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == map.get(player)) countRow++;
                if (grid[j][i] == map.get(player)) countCol++;
            }
            if (countRow == gridSize || countCol == gridSize || countLeftDia == gridSize || countRightDia == gridSize) return player;
        }
        return 0;
    }

    public static void main(String[] args) {
//        DesignTicTacToe toe = new DesignTicTacToe(3);
//        System.out.println(toe.move(0, 0, 1));
//        System.out.println(toe.move(0, 2, 2));
//        System.out.println(toe.move(2, 2, 1));
//        System.out.println(toe.move(1, 1, 2));
//        System.out.println(toe.move(2, 0, 1));
//        System.out.println(toe.move(1, 0, 2));
//        System.out.println(toe.move(2, 1, 1));

        DesignTicTacToe toe = new DesignTicTacToe(2);
        System.out.println(toe.move(0, 1, 1));
        System.out.println(toe.move(1, 1, 2));
        System.out.println(toe.move(1, 0, 1));

    }
}
