package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class SingleElementInASortedArray {

    public static int singleNonDuplicate(int[] nums) {
        int index = 0;
        for(int  i= 0 ; i < nums.length-1 ; i +=2 ){
            if(nums[i] != nums[i+1]){
                index = i;
                break;
            } else {
                index = nums.length - 1;
            }

        }
        return nums[index];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8,9,9};
        int res = singleNonDuplicate(nums);
        System.out.println(res);
    }
}
