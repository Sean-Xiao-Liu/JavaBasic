package LeetCode;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 * Note:
 *
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * */

public class MaxConsecutiveOnes {

    // use fast and slow pointer
    public static int findMaxConsecutiveOnes(int[] nums) {
        int slow = 0;
        int fast = 0;
        int result = 0;

        for(int i = 0;i < nums.length ; i++){

            if(nums[i] == 1){
                fast += 1;
                result = Math.max(result,(fast-slow));
            } else {
                result = Math.max(result,(fast-slow));
                slow = i;
                fast = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1,1,0,0,1,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
