package LeetCode.Array;

import java.util.*;
import java.util.stream.Collectors;

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

    // memthod 3 use hashMap
    public static List<Integer> findDuplicates3(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            } else {
                map.put(i,1);
            }
        }

        return map.entrySet()
                .stream()
                .filter(x -> x.getValue() == 2)// leave the pair with value == 2
                .map(x -> x.getKey())// map x to be key only
                .collect(Collectors.toList()); // collect the key as a list and return
    }



    public static void main(String[] args) {
        int[] nums = {1,5,2,4,3,2,4,5};
        List<Integer> ans = findDuplicates3(nums);
        for(int n:ans){
            System.out.println(n);
        }
    }
}
