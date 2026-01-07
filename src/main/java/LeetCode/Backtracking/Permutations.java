package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {
    /*** method 1 backtracking ***/
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){ // when each temp list contains all numbers, add the temp list to list
            list.add(new ArrayList<>(tempList));
//            list.add(tempList); //will make all temp list empty
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip the rest operation and i++
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1); // remove the last index of temp list, after the temp list added to the list, back to this step

            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,3,4};
        System.out.println(permute(array));

    }
}
