package LeetCode.Array;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/
public class SearchA2DMatrixII {

    /** method 1 space reduction**/
    /*Intuition

Because the rows and columns of the matrix are sorted (from left-to-right and top-to-bottom, respectively), we can prune \mathcal{O}(m)O(m) or \mathcal{O}(n)O(n) elements when looking at any particular value.

Algorithm

First, we initialize a (row, col)(row,col) pointer to the bottom-left of the matrix.[1] Then, until we find target and return true (or the pointer points to a (row, col)(row,col) that lies outside of the dimensions of the matrix), we do the following: if the currently-pointed-to value is larger than target we can move one row "up". Otherwise, if the currently-pointed-to value is smaller than target, we can move one column "right". It is not too tricky to see why doing this will never prune the correct answer; because the rows are sorted from left-to-right, we know that every value to the right of the current value is larger. Therefore, if the current value is already larger than target, we know that every value to its right will also be too large. A very similar argument can be made for the columns, so this manner of search will always find target in the matrix (if it is present).*/
    public static boolean searchMatrix(int[][] matrix, int target) {
        // boundary case
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]) return false; // if matrix is null or target smaller than smallest number in the matrix or target larger than largest number in the matrix, return false


        // start with the point of the down left corner
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length){
            if(matrix[row][col] > target){ // if larger than target, check previous row
                row--;
            } else if(matrix[row][col] < target){ // if smaller than target, check next column
                col++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(searchMatrix(matrix,20));
    }
}
