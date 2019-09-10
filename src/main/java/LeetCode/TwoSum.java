package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };// get(complement) gives the index of complement
            }
            map.put(nums[i], i);//map.put(key,value)
    }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] nums = {6,5,3,2,9};
        int target = 15;
        int[] result = test.twoSum(nums,target);
        System.out.println(Arrays.toString(result));
    }
}
