package LeetCode;

import java.util.*;

public class FindAllDuplicatesInAnArray {

     //method 1
    public static List<Integer> findDuplicates2(int[] nums) {

        int result[] = new int[nums.length+1];
        List<Integer> ans = new ArrayList<Integer>();

        for(int i = 0 ; i < nums.length; i++){
            result[nums[i]]++;
        }

        for(int j = 0 ; j < result.length ; j ++){
            if(result[j]>1){
                ans.add(j);
            }
        }
        return ans;


    }

    // method 2
    public static List<Integer> findDuplicates(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();// Set is an interface which extends Collection. It is an unordered collection of objects in which duplicate values cannot be stored.
        List<Integer> ans = new ArrayList<Integer>();

        for (int i = 0 ; i < nums.length ; i++){

            int setSizeBefore = set.size();
            set.add(nums[i]);
            if (set.size() == setSizeBefore){
                ans.add(nums[i]);
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] nums = {1,5,2,4,3,2,4,5};
        List<Integer> ans = findDuplicates2(nums);
        for(int n:ans){
            System.out.println(n);
        }
    }
}
