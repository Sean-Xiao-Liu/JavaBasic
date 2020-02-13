package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/*In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.



Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.*/
public class RottingOranges {

    // Use BFS
    // store the position of rotten orange
    static class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Position> q = new LinkedList<>();
        int total = 0, rotten = 0, time = 0;

        // traverse the grid, offer position of rotten orange into queue, and count the total num of orange
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) total++; // count total number of oranges
                if (grid[i][j] == 2) q.offer(new Position(i, j));
            }
        }

        // if there is no orange, return 0;
        if (total == 0) return 0;

        while (! q.isEmpty() && rotten < total) {
            // size is the num of rotten oranges of the last round, standard procedure for BFS
            int size = q.size();

            // count the num of rotten oranges, if it equals to total num, return time;
            rotten += size; // rotten = rotten + size
            if (rotten == total) return time;

            // every round, time ++, each round means the for loop finished for one time
            time++;

            // Continue to dequeue until all rotten oranges of last round are removed from the queue
            for (int i = 0; i < size; i++) {
                Position p = q.poll();

                // check the cell in the left/right/top/down of the rotten orange, if it is a fresh orange, enqueue it.
                if (p.x + 1 < grid.length && grid[p.x + 1][p.y] == 1) {
                    grid[p.x + 1][p.y] = 2;
                    q.offer(new Position(p.x + 1, p.y));
                }
                if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == 1) {
                    grid[p.x - 1][p.y] = 2;
                    q.offer(new Position(p.x - 1, p.y));
                }
                if (p.y + 1 < grid[0].length && grid[p.x][p.y + 1] == 1) {
                    grid[p.x][p.y + 1] = 2;
                    q.offer(new Position(p.x, p.y + 1));
                }
                if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == 1) {
                    grid[p.x][p.y - 1] = 2;
                    q.offer(new Position(p.x, p.y - 1));
                }
            }
        }
        return -1; // when there are still some 1 in the grid
    }



    public static void main(String[] args) {
        RottingOranges test = new RottingOranges();
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int result = test.orangesRotting(grid);
        System.out.println(result);
    }
}
