package LeetCode.Matrix;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1; // 左上角坐标（r1,c1）
        int c1 = 0, c2 = matrix[0].length - 1; // 右下角坐标（r2,c2）
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]); // 从第一行开始取每一列
            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]); // 在最后一列取每一行
            if (r1 < r2 && c1 < c2) { // 从右下角开始重新输出
                for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);//在最后一行取每一列
                for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);//在第一列取每一行
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
}
