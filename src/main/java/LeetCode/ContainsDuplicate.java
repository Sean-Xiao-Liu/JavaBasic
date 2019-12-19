package LeetCode;

import java.lang.reflect.Array;
import java.util.*;

public class ContainsDuplicate {

    /** method 1 use hashSet to remove duplicates*/
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int arrayLength = nums.length;
        for(int i : nums){
            set.add(i);
        }

        int setSize = set.size();
        return !(arrayLength==setSize);

    }
    /** method 2 use Stream for internal iterate*/
    public static boolean containsDuplicate2(int[] nums) {
        int arrayLength = nums.length;
        long distinctCount = Arrays.stream(nums).distinct().count();
        return !(arrayLength == distinctCount);
    }

    /** method 3 use HashMap*/
    public static boolean containsDuplicate3(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                return true;
            } else {
                map.put(i,0);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        System.out.println(containsDuplicate3(array));
    }
}
