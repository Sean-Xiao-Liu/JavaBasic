package LeetCode;

public class HouseRobber {
    public int rob(int[] nums) {
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

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,10,3,2,7,1};
        HouseRobber h = new HouseRobber();
        System.out.println(h.rob(nums));
    }
}
