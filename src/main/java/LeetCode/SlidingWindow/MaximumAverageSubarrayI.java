package LeetCode.SlidingWindow;

/**
 * You are given an integer array nums consisting of n elements, and an integer
 * k.
 * 
 * Find a contiguous subarray whose length is equal to k that has the maximum
 * average value and return this value. Any answer with a calculation error less
 * than 10-5 will be accepted.
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        // set the baseline of first k elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxSum = sum;
        // slide the window to the right
        for (int right = k; right < nums.length; right++) {
            sum += nums[right] - nums[right - k]; // slide: add new, remove old
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 12, -5, -6, 50, 3 };
        new MaximumAverageSubarrayI().findMaxAverage(nums, 4);
    }
}
