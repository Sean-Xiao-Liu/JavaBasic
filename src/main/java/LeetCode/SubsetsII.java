package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums); //sort the nums so the duplicates can be skipped
        backtrack(lists,new ArrayList<>(),nums,0);
        return lists;

    }

    private static void backtrack(List<List<Integer>> lists, List<Integer> temp, int[] nums, int start){
        lists.add(new ArrayList<>(temp));
        for(int i = start ; i < nums.length ; i++){ // for i = start , not  0
            if(i > start && nums[i] == nums[i-1]) continue; // start from the 2nd index of the nums to check duplicate
            temp.add(nums[i]);
            backtrack(lists,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        System.out.println(subsetsWithDup(nums));
    }
}
