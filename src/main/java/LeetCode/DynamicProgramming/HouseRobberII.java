package LeetCode.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HouseRobberII {
    public int help(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        int largestExceptPreviousNum = 0;

        for(int i = 2; i < nums.length+1;i++){
            dp[i] = largestExceptPreviousNum + nums[i-1];
            if(dp[i-1] > largestExceptPreviousNum) largestExceptPreviousNum = dp[i-1];
        }
        if(dp[nums.length] > largestExceptPreviousNum) return dp[nums.length];
        return largestExceptPreviousNum;
    }

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] noHead = Arrays.copyOfRange(nums,1,nums.length);
        int[] noTail = Arrays.copyOfRange(nums,0,nums.length-1);
        return Math.max(help(noHead),help(noTail));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,10,3,2,7,1};
        Arrays.copyOfRange(nums, 0, 1);
        HouseRobberII h = new HouseRobberII();
        System.out.println(h.rob(nums));
    }
}
