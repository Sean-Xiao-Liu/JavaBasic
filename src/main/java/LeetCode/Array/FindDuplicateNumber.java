package LeetCode.Array;




import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.*/
public class FindDuplicateNumber {

    /** method 1 two pointer, for constant space, use temp int and two pointer method**/
    public static int findDuplicate(int[] nums) {
        int temp = 0; // integers in nums are between 1 and n
        for(int i = 0 ; i < nums.length-1 ; i++){
            temp = nums[i];
            for(int j = i+1 ; j < nums.length;j++){
                if (nums[j] == temp) return temp;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        System.out.println(findDuplicate3(nums));
    }

    /** method 2 use map **/
    public static int findDuplicate2(int[] nums) {
        int temp = 0; // integers in nums are between 1 and n
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                return map.get(nums[i]);
            } else {
                map.put(nums[i],nums[i]);
            }
        }
        return temp;
    }

    /** method 3 set**/
    public static int findDuplicate3(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) { // use contains method instead of length
                return num;
            }
            seen.add(num);
        }

        return -1;
    }
}
