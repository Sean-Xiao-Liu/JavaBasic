package LeetCode;

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
*/
public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] matrix = new int[obstacleGrid.length][obstacleGrid[0].length]; // format a matrix to store the possible pass;
//        matrix[0][0] = 1;
        // double for loop to iterate in the input matrix
        for(int i = 0 ; i < obstacleGrid.length ; i++){
            for(int j = 0 ; j < obstacleGrid[0].length ; j++){

                // for the first row of matrix
                if(i == 0){

                    if(obstacleGrid[i][j] == 0){
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = 0;
                    }
                    // if there is a obstacle is first row, all the rest would be 0
                    if(j != 0 ){
                        if(matrix[i][j-1] == 0) matrix[i][j] = 0;
                    }

                }

                if(j == 0){
                    if(obstacleGrid[i][j] == 0){
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = 0;
                    }
                    // if there is a obstacle is first row, all the rest would be 0
                    if(i != 0){
                        if(matrix[i-1][j] == 0) matrix[i][j] = 0;
                    }

                }

                // for other condition
                if(j != 0 && i != 0){
                    if(obstacleGrid[i][j] == 1){
                        matrix[i][j] = 0;
                    } else {
                        matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                    }
                }
            }
        }
        return matrix[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }


    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,0,0,0},
                {0,1,1,0},
                {0,0,0,0}
        };

        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
