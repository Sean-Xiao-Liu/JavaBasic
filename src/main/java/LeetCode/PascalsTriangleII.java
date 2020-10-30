package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
 *
 * Notice that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 *
 *
 * Example 1:
 *
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 *
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 *
 * Input: rowIndex = 1
 * Output: [1,1]
 * */
public class PascalsTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row =
                new ArrayList<Integer>(rowIndex + 1) {
                    {
                        add(1);
                    }
                };


        // start from tail to add the index of previous row
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }

        return row;
    }

    public static void main(String[] args) {
        getRow(5);
    }
}
