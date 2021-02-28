package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumberAtLeastTwiceOfOthers {

    // sort the the array and verify if the largest one is at least twice of others
    public static int dominantIndex(int[] nums) {


        if(nums.length == 0) return -1;
        if(nums.length == 1) return 0;

        List<Integer> origin = Arrays.stream(nums).boxed().collect(Collectors.toList()); // copy of the original array
        Arrays.sort(nums);
        if(nums[nums.length-1] >= 2*nums[nums.length-2]){
            return origin.indexOf(nums[nums.length-1]);
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{1,0}));
    }
}
