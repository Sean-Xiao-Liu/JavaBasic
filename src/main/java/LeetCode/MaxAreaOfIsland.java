package LeetCode;

import java.util.Stack;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        Stack<Integer> areaStack = new Stack<Integer>();

        int maxArea = 0;
        for(int i=0 ; i < grid.length; i++){
            for(int j=0; j < grid[i].length; j++){
                int area = flipAndCount(i,j,grid);
                    areaStack.push(area);
            }
        }

        for(int i = 0 ; i < areaStack.size(); i++){
            int area = areaStack.pop();
            if(area > maxArea) maxArea = area;
        }
        return maxArea;
    }

    public int flipAndCount(int i, int j, int[][] grid){
        int count = 0;
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return count;
        }

        if (grid[i][j] == 1) {
            count++;
            grid[i][j] = 0; // flip the 1 to 0 after count
            flipAndCount(i, j - 1, grid);
            flipAndCount(i, j + 1, grid);
            flipAndCount(i - 1, j, grid);
            flipAndCount(i + 1, j, grid);
        }
        return count;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland test = new MaxAreaOfIsland();
        int[][] grid = {{1,1,1,0},{1,1,0,0},{1,0,0,0},{0,0,0,1}};
        int result = test.maxAreaOfIsland(grid);
        System.out.println("the max island area is: " + result);

    }


}
