package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];  // dp[i] will hold the length of the LIS ending at index i
        int result = 1;  // The minimum LIS length is always 1 (the element itself)

        // Every element itself can be a subsequence of length 1
        Arrays.fill(dp,1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // If nums[i] can extend the subsequence ending at nums[j]
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // Update dp[i] with the maximum subsequence length
                }
            }
            // Update the result with the longest subsequence found so far
            result = Math.max(result, dp[i]);
        }

        return result;
    }


    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        List<Integer> sub = new ArrayList<>();
        for (int num : nums) {
            // Use binary search to find the position where num should go
            int pos = Collections.binarySearch(sub, num);
            System.out.println("pos value: "+pos);
            if (pos < 0) pos = -(pos + 1);  // If not found, binarySearch returns -(insertion point) - 1, 固定搭配

            // If pos equals the size of sub, num is greater than all elements, so we append
            if (pos >= sub.size()) {
                System.out.println("add num: "+num);
                sub.add(num);
            } else {
                System.out.println("set num: "+num+" at position: "+pos);
                sub.set(pos, num);  // Otherwise, replace the element at pos
            }
        }

        // The size of sub is the length of the LIS
        return sub.size();
    }


    public static void main(String[] args) {
        int[] nums = new int[]{4,10,4,3,8,9};
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        System.out.println(l.lengthOfLIS2(nums));

    }
}
