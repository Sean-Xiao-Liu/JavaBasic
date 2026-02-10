package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 */
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {

        /**** method 1 brutal force ****/
        /* Doesn't pass the LeetCode test since the overtime */
        int temp = Integer.MIN_VALUE;// should be minimum int here

        ArrayList<Integer> list = new ArrayList<Integer>(nums.length);// transfer int array to integer array list to
                                                                      // apply sublist
        for (int i = 0; i < nums.length; i++) {
            list.add(Integer.valueOf(nums[i]));
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0; // renew sum for each subList sum up
                List<Integer> tempList = list.subList(i, j + 1);
                for (int k = 0; k < tempList.size(); k++) {
                    sum += tempList.get(k);
                    temp = Math.max(temp, sum);
                }
            }
        }
        return temp;
    }

    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0)
                // reset sum to 0 if it's negative, not reset max
                sum = 0; 
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(nums));
        Math.sqrt(2);
    }

}
