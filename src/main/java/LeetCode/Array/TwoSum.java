package LeetCode.Array;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*** method 1 using HashMap ***/
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

    /*** method 2 brutal force***/
    public static int[] twoSum2(int[] nums, int target){
        for(int i = 0 ; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int temp = nums[i] + nums[j];
                if(temp == target) return new int[] {i,j};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*** method 1 v2 redo the HashMap method, 10/30/19 ***/
    public static int[] twoSum3(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();// create a map to look up
        for(int i = 0 ; i < nums.length ; i++){
            int temp = target - nums[i]; // temp is the value to look up among keys
            if(map.containsKey(temp)) {
                return new int[] {map.get(temp), i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] nums = {6,5,3,2,9};
        int target = 15;
//        int[] result = test.twoSum(nums,target);
//        int[] result2 = twoSum2(nums,target);
        int[] result3 = twoSum3(nums,target);
//        System.out.println(Arrays.toString(result));
//        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
    }
}
