package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindFirstAndLastPositionOfElementInSortedArray {

    /** method 1 brutal force**/
    public static int[] searchRange(int[] nums, int target) {
       List<Integer> position = new ArrayList();
       int[] result = {-1,-1};
        if(nums.length == 0) return result;
        for(int i = 0; i < nums.length ; i++){
           if(nums[i] == target) position.add(i);
       }

       if (position.size() == 0){
           return result;
       } else {
           Collections.sort(position);
           result[0] = position.get(0);
           result[1] = position.get(position.size()-1);
       }
        return result;
    }

    /** method 2**/
    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public static int[] searchRange2(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }

    public static void main(String[] args) {
        int target = 8;
        int[] nums = {1,2,5,6,8,8,8,9};
        int[] result = searchRange2(nums,target);
        for(int j : result){
            System.out.println(j);
        }

    }
}
