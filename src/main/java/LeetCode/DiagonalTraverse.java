package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {

        // Check for empty matrices
        // These are boundary cases
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length; // number of rows
        int M = matrix[0].length; // number of columns

        // The two arrays as explained in the algorithm
        int[] result = new int[N*M];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<Integer>();

        // We have to go over all the elements in the first
        // row and the last column to cover all possible diagonals
        // M represent the first row, N represent the last column
        for (int d = 0; d < N + M - 1; d++) {

            // Clear the intermediate array every time we start
            // to process another diagonal
            // do this instead of creating a new int array each time
            // to save space
            intermediate.clear();

            // We need to figure out the "head" of this diagonal
            // The elements in the first row and the last column
            // are the respective heads.
            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            // Iterate until one of the indices goes out of scope
            // Take note of the index math to go down the diagonal
            while (r < N && c > -1) {

                intermediate.add(matrix[r][c]);
                ++r;
                --c;
            }

            // Reverse even numbered diagonals. The
            // article says we have to reverse odd
            // numbered articles but here, the numbering
            // is starting from 0 :P
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }
        return result;
    }
}
