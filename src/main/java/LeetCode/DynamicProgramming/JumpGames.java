package LeetCode.DynamicProgramming;

public class JumpGames {
    public static void main(String[] args) {
        int[] firstNums = {2,3,1,1,4};
        int[] secondNums = {3,2,1,0,4};

        JumpGames test = new JumpGames();
        System.out.println("Test if result is true : " + test.canJump(firstNums));
        System.out.println("Test if result is false : " + test.canJump(secondNums));
        System.out.println("Test if result is true : " + test.canJump2(firstNums));
        System.out.println("Test if result is false : " + test.canJump2(secondNums));
    }








    /** method 1 backtracking**/
    public boolean canJump(int[] nums) {
        return backtrack(nums,0);
    }

    private static boolean backtrack(int[] nums, int temp){ // temp mark the current index
        if(temp == nums.length - 1){
            return true;
        }

        int furthest = Math.min(temp + nums[temp],nums.length - 1);
        for(int i = temp+1 ; i <= furthest ; i++){ // i has to start with temp + 1, or it will be infinite loop and lead to java.lang.StackOverflowError
            if(backtrack(nums,i)) return true; // backtrack return value is not void this time
        }
        return false;
    }

    /** method 2 greedy**/
    public boolean canJump2(int[] nums){
        int position = nums.length-1;
        for(int i = nums.length-1;i >= 0;i--){ // start from the last index
            if(i+nums[i] >= position){
                position = i; // if can reach the position from i index, update the position index
            }
        }
        return position == 0;
    }

}
