package LeetCode;

import Utils.PrintUtil;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums.length == 1 || k == 0) return;

        int[] newNums = new int[nums.length];
        for(int i = 0; i < nums.length ;i++){
            int newIndex = (i+k)%nums.length;
            newNums[newIndex] = nums[i];
        }

        for(int i = 0; i < nums.length ;i++){
            nums[i] = newNums[i];
        }

    }

    public void rotate2(int[] nums, int k) {
        if(nums.length == 1 || k == 0) return;
        int switchCount = 0;
        int index = 0;
        int replacedNumber = 0;
        int newIndex = 0;
        int number = nums[index];
        while(switchCount < nums.length){
            newIndex = (index+k)%nums.length;
            replacedNumber = nums[newIndex];
            nums[newIndex] = number;
            number = replacedNumber;
            index = newIndex;
            switchCount++;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate2(nums,2);
        PrintUtil.print(nums);
    }
}
