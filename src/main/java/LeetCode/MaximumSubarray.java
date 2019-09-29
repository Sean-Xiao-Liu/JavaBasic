package LeetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {

        /**** method 1 brutal force****/
        /* Doesn't pass the LeetCode test since the overtime*/
        int temp = Integer.MIN_VALUE;// should be minimum int here

        ArrayList<Integer> list = new ArrayList<Integer>(nums.length);// transfer int array to integer array list to apply sublist
        for (int i = 0; i < nums.length; i++) {
            list.add(Integer.valueOf(nums[i]));
        }

        for(int i = 0; i < nums.length ; i++){
            for(int j = i; j < nums.length; j++){
                int sum = 0; // renew sum for each subList sum up
                List<Integer> tempList = list.subList(i,j+1);
                for(int k = 0; k < tempList.size() ; k++){
                    sum += tempList.get(k);
                    temp = Math.max(temp,sum);
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        Math.sqrt(2);
    }

}
