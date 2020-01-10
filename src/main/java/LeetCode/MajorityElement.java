package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public  static int majorityElement(int[] nums) {
        //use map to store the appearance of each number
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;  i < nums.length ; i++){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int result = 0;

        for(Integer i : map.keySet()){
            if(map.get(i) > nums.length/2)
                result = i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};

        System.out.println(majorityElement(nums));
    }
}
