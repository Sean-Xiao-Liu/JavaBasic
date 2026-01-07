package LeetCode.DynamicProgramming;

public class CombinationSum4 {
//    public int combinationSum4(int[] nums, int target) {
//        int[] dp = new int[target + 1];
//
//        for (int i = 1; i < target + 1; i++) {
//            int count = 0;
//            for (int j = 0; j < nums.length; j++) {
//                if (i - nums[j] == 0) count++;
//                if (i - nums[j] > 0) count += dp[i - nums[j]];
//            }
//            dp[i] = count;
//        }
//
//        return dp[target];
//    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // set dp[0] to be 1 instead of 0
        for (int i = 1; i <= target; i++) {
            for (int num : nums) { // not use int j
                if (i - num >= 0)
                    dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        CombinationSum4 c = new CombinationSum4();
        System.out.println(c.combinationSum4(nums, 10));
    }
}
