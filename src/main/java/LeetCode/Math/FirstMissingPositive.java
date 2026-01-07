package LeetCode.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FirstMissingPositive {

    /** method 1 construct another list**/
    public static int firstMissingPositive(int[] nums) {

        if (nums.length == 0) return 1;
        // find the max positive integer
        int max = Arrays.stream(nums).max().getAsInt();
        if (max < 0) return 1;

        List<Integer> list= IntStream.range(1,max+2).boxed().collect(Collectors.toList());

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > 0) list.remove(Integer.valueOf(nums[i]));
        }
        return list.get(0);

    }

    /** method 2**/

    public static int firstMissingPositive2(int[] nums) {

        if (nums.length == 0) return 1;
        // find the max positive integer
        int max = Arrays.stream(nums).max().getAsInt();
        if (max < 0) return 1;

        List<Integer> list= Arrays.stream(nums).boxed().collect(Collectors.toList());

        for(int i = 1 ; i < max ; i++){
            if(!list.contains(Integer.valueOf(i))) return i;
        }
        return max+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2};
        System.out.println(firstMissingPositive2(nums));
    }
}
