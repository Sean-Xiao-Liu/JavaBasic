package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,new ArrayList<>(),nums,0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums,int start){
        list.add(new ArrayList<>(temp)); // no limit on the length of temp list, so just add whatever it have to the list
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(subsets(nums));
        System.out.println("size of possible combine " + subsets(nums).get(5));
    }
}
