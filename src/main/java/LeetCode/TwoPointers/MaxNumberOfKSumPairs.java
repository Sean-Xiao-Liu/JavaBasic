package LeetCode.TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array nums and an integer k.
 * 
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * 
 * Return the maximum number of operations you can perform on the array.
 */
public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        // Sort the array to use two-pointer technique
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];

            if (sum == k) {
                // Found a valid pair
                count++;
                i++;
                j--;
            } else if (sum > k) {
                // Too big, move the end pointer
                j--;
            } else {
                // Too small, move the start pointer
                i++;
            }
        }

        return count;
    }

    // method 2: HashMap approach - O(n) time, O(n) space
    public int maxOperationsHashMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int complement = k - num; // complement is the number that needs to be found to make the sum equal to k
            if (map.getOrDefault(complement, 0) > 0) {
                // Found a pair — use up one instance of complement
                count++;
                map.put(complement, map.get(complement) - 1); // use up one instance of complement so that it can't be used again
            } else {
                // No pair yet — store this number for later
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,3,4,3,3};
        int k = 6;
        MaxNumberOfKSumPairs m = new MaxNumberOfKSumPairs();
        System.out.println(m.maxOperations(nums, k));
    }
}
