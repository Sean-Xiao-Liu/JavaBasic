package LeetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<Integer,Integer> entry = it.next();
            if(entry.getValue() == 1) return entry.getKey();
        }
        return 0;

    }

    public static void main(String[] args) {
        int[] nums = {2,2,4,4,5,5,3};
        System.out.println(singleNumber(nums));
    }
}
