package LeetCode.Array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 0);
        int countOfZero = 0;
        int product = 1;
        for (int num : nums) {
            if (num == 0) { countOfZero++; }
            else { product *= num; }
        }

        if(countOfZero > 1) return result;

        if(countOfZero == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    result[i] = product;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                result[i] = product / nums[i];
            }
        }
        
        return result;

    }

}
