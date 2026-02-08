package LeetCode.SlidingWindow;
/**
 * Given a binary array nums, you should delete one element from it.
 * 
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 */
public class LongestSubarrayOf1AfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        // // This subarray can have up to one 0
        // // length = right - left - zeroCount + 1
        // int left = 0, right = 0, res = 0, zeroCount = 0;
        // while (right < nums.length) {
        //     if (nums[right] == 1) {
        //         right++;
        //         int size = right - left - zeroCount + 1;
        //     } else {
        //        if (zeroCount == 1) {
        //         left++; // move left pointer 
        //         zeroCount--; // 
        //        } else {
        //         zeroCount++; // if only have one 0
        //        }
        //     }
        // }
        // return res;

        int n = nums.length;

        int left = 0;
        int zeros = 0;
        int ans = 0;
        // right pointer always move forward, so use for loop instead of while loop
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > 1) { // if there are more than one 0, move left pointer to the right
                if (nums[left] == 0) {
                    zeros--;
                }
                left++; // keep moving left pointer to the right until there is only one 0
            }
            // calculate the length of the subarray
            ans = Math.max(ans, right - left + 1 - zeros);
        }
        // if the length of the subarray is equal to the length of the array, return ans - 1
        // because we deleted one element, which is a 1
        return (ans == n) ? ans - 1 : ans;
    }
}
