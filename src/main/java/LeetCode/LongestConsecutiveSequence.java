package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    /**
     * Can't use DP here as there are some negative values in num
     * @param nums
     * @return
     */
//    public int longestConsecutive(int[] nums) {
//        if (nums.length == 0) return 0;
//        // find max value in the array
//        int maxValue = Arrays.stream(nums).max().getAsInt();
//
//        // update dp array if the
//        int[] dp = new int[maxValue+1];
//        for(int i = 0; i < nums.length ;i++){
//            dp[nums[i]] = 1;
//        }
//        int count  = 0;
//        int result = 0;
//
//        for(int j = 0 ; j < dp.length ; j++){
//            if (dp[j]==1){
//                count++;
//                result = Math.max(count,result);
//            } else {
//                count = 0;
//            }
//        }
//        return result;
//    }

    public int longestConsecutive(int[] nums) {
        // Base case: if the array is empty, return 0
        if (nums == null || nums.length == 0) return 0;

        // Use a HashSet to store all elements of the array
        Set<Integer> numSet = new HashSet<>(); // HashSet has O(1) search and insertion
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Iterate over the array and find the longest consecutive sequence
        for (int num : nums) {
            // Only consider starting a sequence if num-1 is not in the set
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers starting from currentNum
                while (numSet.contains(currentNum + 1)) { // lookup in set with O(1)
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak found
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        System.out.println(l.longestConsecutive(nums));


    }

}
