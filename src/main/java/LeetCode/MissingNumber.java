package LeetCode;

import Utils.PrintUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        // construct an array with length n+1 and filled with -1
        int[] array = new int[nums.length+1];
        Arrays.fill(array,-1);
        for(int i = 0 ; i < nums.length; i++){
            array[nums[i]] = nums[i];
        }
        // in array the index and value should match
        for(int j = 0 ; j < array.length ;j++){
            if(array[j] != j) return j;
        }
        return -1;
    }

    public static int missingNumber2(int[] nums) {
        int length = nums.length;
        int expectedSum = length * (length+1)/2;
        int sum = 0;
        for(int i:nums){
            sum = sum+i;
        }
        return expectedSum-sum;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
    }
}
