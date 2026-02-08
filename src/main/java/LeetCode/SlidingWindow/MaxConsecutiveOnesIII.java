package LeetCode.SlidingWindow;

/**
 * Given a binary array nums and an integer k,
 * return the maximum number of consecutive 1's in the array if you can flip at
 * most k 0's.
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        int zeros = 0;
        int ans = 0;
        // right pointer always move forward, so use for loop instead of while loop
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) { // if there are more than k 0, move left pointer to the right
                if (nums[left] == 0) {
                    zeros--;
                }
                left++; // keep moving left pointer to the right until there is only k 0
            }
            // calculate the length of the subarray
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        System.out.println(new MaxConsecutiveOnesIII().longestOnes(nums, 3));
    }
}
