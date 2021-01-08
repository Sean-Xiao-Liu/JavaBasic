package LeetCode;

public class FindPivotIndex {
    /** method 1  3 traversal 2 extra array*/
    public static int pivotIndex(int[] nums) {

        if(nums.length == 1) {
            return 0;
        } else if(nums.length == 0){
            return -1;
        }

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];


        for(int i = 0; i < nums.length-1 ; i++){
            left[i+1] = nums[i] + left[i];
        }

        for(int j = nums.length - 1; j > 0 ; j--){
            right[j-1] = right[j] + nums[j];
        }

        for (int k = 0 ; k < nums.length;k++){
            if(left[k] == right[k]) return k;
        }

        return -1;
    }

    /** method 2  2 traversal 1 extra array*/
    public static int pivotIndexTwo(int[] nums) {

        if(nums.length == 1) {
            return 0;
        } else if(nums.length == 0){
            return -1;
        }

        int[] left = new int[nums.length];
        int sum = 0;
//        int[] right = new int[nums.length];


        for(int i = 0; i < nums.length-1 ; i++){
            left[i+1] = nums[i] + left[i];
            sum = sum + nums[i];
        }
        sum = sum + nums[nums.length-1];

//        for(int j = nums.length - 1; j > 0 ; j--){
//            right[j-1] = right[j] + nums[j];
//        }
        int temp = sum;
        for (int k = 0 ; k < nums.length;k++){
            temp = temp - nums[k];
            if(temp == left[k]) return k;

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] testArrayOne = {1,7,3,6,5,6};
        int[] testArrayTwo = {1,2,0};
        System.out.println(pivotIndexTwo(testArrayOne));
        System.out.println(pivotIndexTwo(testArrayTwo));
    }
}
