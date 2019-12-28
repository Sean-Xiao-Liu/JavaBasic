package LeetCode;

import org.omg.CORBA.MARSHAL;

import java.util.Stack;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
//        Stack<Integer> areaStack = new Stack<Integer>();// stack will slow down the execution speed

        int maxArea = 0;
        for(int i=0 ; i < grid.length; i++){
            for(int j=0; j < grid[i].length; j++){
                if(grid[i][j]==1) {
                    int area = flipAndCount(i, j, grid);
//                    maxArea = Math.max(maxArea, areaStack.push(area));// unnecessary
                    maxArea = Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }

    public int flipAndCount(int i, int j, int[][] grid){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 0;

        grid[i][j] = 0; // change the counted number to be zero, so it will not be count again when recurse back
        return (1 + flipAndCount(i, j - 1, grid)+
        flipAndCount(i, j + 1, grid)+
        flipAndCount(i - 1, j, grid)+
        flipAndCount(i + 1, j, grid));

    }

    public static void main(String[] args) {
        MaxAreaOfIsland test = new MaxAreaOfIsland();
        int[][] grid = {{1,1,1,0},{1,1,0,0},{1,0,0,0},{0,0,0,1}};
        int result = test.maxAreaOfIsland(grid);
        System.out.println("the max island area is: " + result);

    }


}
