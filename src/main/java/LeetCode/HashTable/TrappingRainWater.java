package LeetCode.HashTable;

import java.util.Arrays;

public class TrappingRainWater {

    /** method 1 brutal force**/
    public static int trap(int[] height) {
        // need at least 3 index to
        if(height.length == 0 || height.length == 1 || height.length == 2) return 0;

        //sum the height before trapping
        int before = sumArray(height);

        // different case
        for(int i = 1; i < height.length - 1; i++){

            int leftMax = 0;
            int rightMax = 0;
            //if height of left bar and right bar both lower than current bar, this bar will not hold any water
            if(height[i] >= height[i-1] && height[i] >= height[i+1]){
                continue;
            } else {
                //get leftMax
                for(int j = i-1 ; j >= 0 ; j--){
                    if(height[j] > leftMax) leftMax = height[j];
                }
                for(int k = i+1 ; k < height.length ; k++){
                    if(height[k] > rightMax) rightMax = height[k];
                }
            }
            // the height of this bar = original height + water height
            if(leftMax >= height[i] && rightMax >= height[i]){
                height[i] = leftMax >= rightMax ?  rightMax : leftMax;
            }
        }

        // sum height after trapping
        int after = sumArray(height);
        return after - before;

    }
    private static int sumArray(int[] array){
        return Arrays.stream(array).sum();
    }

    /** method 2  two pointer**/
    public static int trap2(int[] height) {
        int left = 0, right = height.length-1; // left and right are the index pointer on each side
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {

            // work  on the side with lower absolute height
            if (height[left] < height[right]) { // when height on left pointer is lower
                if(height[left] >= left_max){
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            }
            else { // when height on right pointer is lower
                if(height[right] >= right_max){
                    right_max = height[right];
                } else{
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }





    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = {3,0,1,2,3,4};
        int[] height3 = {5,4,3,2,5};
        System.out.println(trap2(height2));
    }
}
