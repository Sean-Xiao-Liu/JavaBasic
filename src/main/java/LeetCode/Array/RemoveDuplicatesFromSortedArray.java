package LeetCode.Array;

import java.util.*;


// notes the array is sorted
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
//        /**** method 1  ignore the space limit ****/
//        Set<Integer> set = new HashSet<Integer>();
//        List<Integer> list = new ArrayList<Integer>();
//
//        if(nums.length == 0 || nums.length == 1) return nums.length;
//        for (int i = 0 ; i < nums.length ; i++ ){
//            int setSize = set.size();
//            set.add(nums[i]);
//            if(set.size() != setSize){ // if there is a difference, it means the number is not duplicated
//                list.add(nums[i]);
//            }
//        }
//        return list.size();
        /**** method 2 fast and slow pointer ****/
        if(nums.length == 0 || nums.length == 1) return nums.length;
        int slow = 0;
        int fast = 0;
        while(fast < nums.length){
            if(nums[slow] == nums[fast]){
                fast++;
            } else {
                slow++; // the slow pointer needs to move first before the number of that index changed
                nums[slow] = nums[fast];
                fast++;
            }
        }
        return slow+1;// the index is the length minus 1
    }

    /*** method 1 v2 redo , 11/10/19***/
    public static int removeDuplicates2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length;i++) set.add(nums[i]);
        return set.size();
    }

    /*** method 2 v2 redo , 11/10/19***/
    public static int removeDuplicates3(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        int fast = 0;
        int slow = 0;
        while(fast < nums.length){
            if(nums[slow] == nums[fast]){
                fast++;
            }else{
                slow++; // slow pointer move first since hte next index should be changed
                nums[slow] = nums[fast];
                fast++;
            }
        }
        return slow+1;
    }

    public static int removeDuplicates4(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        int count = 0;
        for (int i = 0 ; i < nums.length ;i++){
            if(nums [i] != nums[count]){
                count++;
                nums[count] = nums[i];
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicates2(nums));
        System.out.println(removeDuplicates3(nums));
    }
}
