package LeetCode.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindFirstAndLastPosition {

    /*** method 1 brutal force with time complexity O(n) ***/
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if (nums == null) return result;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length ; i++){
            if(nums[i] == target) list.add(i);
        }
        if(list.isEmpty()){ //
            return result;
        } else {
            result[0] = list.get(0); // the first time target show up
            result[1] = list.get(list.size()-1); // the last time that target show up
        }
        return result;
    }


    /*** method 2 linear scan with time complexity O(n) ***/

    public static int[] searchRange2(int[] nums, int target){
        int[] targetRange = {-1, -1};

        // find the index of the leftmost appearance of `target`.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                targetRange[0] = i;
                break;
            }
        }

        // if the last loop did not find any index, then there is no valid range
        // and we return [-1, -1].
        if (targetRange[0] == -1) {
            return targetRange;
        }

        // find the index of the rightmost appearance of `target` (by reverse
        // iteration). it is guaranteed to appear.
        for (int j = nums.length-1; j >= 0; j--) {
            if (nums[j] == target) {
                targetRange[1] = j;
                break;
            }
        }

        return targetRange;
    }

    /*** method 3 binary search with time complexity***/
    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public static int[] searchRange3(int[] nums, int target) {
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
        int[] nums = {5,7,7,8,8,8,10};
        int[] result = searchRange3(nums,8);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
