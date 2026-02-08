package LeetCode.TwoPointers;
/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 * 
 * Example 1:
 * 
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Example 2:
 * 
 * Note: You may not slant the container and n is at least 2.
 */ 
public class ContainerWithMostWater {

    // method 1 brute force
//    public int maxArea(int[] height) {
//        int maxArea = 0;
//        int temp = 0;
//        for(int i = 0; i < height.length ; i++){
//            for(int j = i+1; j < height.length; j++){
//                if(height[i] <= height[j]){
//                    temp = height[i]*(j-i);
//                } else {
//                    temp = height[j]*(j-i);
//                }
//                maxArea = Math.max(maxArea,temp);
//            }
//        }
//        return maxArea;
//    }

    // 2 pointer
    public int maxWater(int[] height, int left, int right){
        int maxArea = 0;
        int area;
        while(right > left){
            if(height[left] >= height[right]){
                area = height[right]*(right - left); // max level of water is determined by lower bound, and vice versa
                right--;
            } else { // can't write two if here since they would be parallel.
                area = height[left]*(right - left);
                left++;
            }
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        return maxWater(height,left,right);
    }




    public static void main(String[] args) {
        ContainerWithMostWater test = new ContainerWithMostWater();
        int[] height = {1,2,1};
        System.out.println("The max area of container is:\n" + test.maxArea(height));
    }
}
