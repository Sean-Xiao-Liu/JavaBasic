package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list,new ArrayList<>(),nums,new boolean[nums.length]); // the length of array needs to be given at claim time
        return list;
    }

    /* Add check point here to check if the number has been used, this is different
       compare to the permutation
     */
    private static void backtracking(List<List<Integer>> list, List<Integer> temp, int[] nums, boolean[] used){
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
        } else {
            for(int i = 0 ; i < nums.length ; i++){

            }
        }

    }
}
