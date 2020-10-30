package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * */

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        // i is the number of rows here
        for(int i = 0; i < numRows ; i++){

            // fill the head and tail of each array with 1
            Integer[] data = new Integer[i+1];
            Arrays.fill(data,new Integer(0));
            data[0] = 1;
            data[data.length-1] = 1;

            // add corresponding number in the previous array
            if(i >= 2){
                for(int j = 1 ; j <= i-1 ; j++){
                    data[j] = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                }
            }



            List<Integer> list = Arrays.asList(data);
            result.add(new ArrayList<>(list));
        }

        return result;


    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
