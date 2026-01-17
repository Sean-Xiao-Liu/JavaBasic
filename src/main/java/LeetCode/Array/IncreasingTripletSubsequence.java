package LeetCode.Array;

public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for (int num : nums) {
            System.out.println("num: " + num);
            System.out.println("a before loop: " + a);
            System.out.println("b before loop: " + b);
            if (num <= a) {
                a = num; // a is the smallest number so far
                System.out.println("a after loop: " + a);
            } else if (num <= b) {
                b = num; // b is the second smallest number so far
                System.out.println("b after loop: " + b);
            } else {
                return true; // if num is greater than a and b, then we have found a triplet`
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 4,1,6 };
        System.out.println(IncreasingTripletSubsequence.increasingTriplet(nums));
    }
}
