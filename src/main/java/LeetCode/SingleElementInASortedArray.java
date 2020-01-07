package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class SingleElementInASortedArray {

    public static int singleNonDuplicate(int[] nums) {
        int index = 0;
        for(int  i= 0 ; i < nums.length-1 ; i +=2 ){
            if(nums[i] != nums[i+1]){
                index = i;
                break;
            } else {
                index = nums.length - 1;
            }

        }
        return nums[index];
    }

    public static int singleNonDuplicate2(int[] nums){
        int n = nums.length;

        int left = 0;
        int right = n - 1;
        while(left < right){
            int mid = left + (right - left)/2;

            if((mid & 1) == 0){ // mid is even, i.e. mid % 2 == 0
                // if mid is "good". find right range
                if(mid + 1 < n && nums[mid] == nums[mid + 1]){
                    left = mid + 2;
                }else{
                    // mid is bad, find left range
                    right = mid;
                }
            }else{ // mid is odd, i.e. mid % 2 == 1
                // if mid is "good", find right range
                if(mid - 1 >= 0 && nums[mid] == nums[mid - 1]){
                    left = mid + 1;
                }else{
                    // mid is "bad", find left range
                    right = mid - 1;
                }
            }
        }

        return nums[left];
    }





    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8,9,9};
        int res = singleNonDuplicate2(nums);
        System.out.println(res);
    }
}
