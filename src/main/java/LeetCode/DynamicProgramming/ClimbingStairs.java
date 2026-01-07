package LeetCode.DynamicProgramming;


import org.junit.Assert;

/* each stair n can be reached from the the n-1 stair and n-2 stair,
* assume there are S_(n-1) different ways to reach the n-1 stair, there is only one way to reach the n stair from the n-1 stair
* similarly, if there are S_(n-2) ways to reach the n-2 stair, there is only one way to reach the n stair from the n-2 stair
* while the ways to get n-1 from n-2 is included in the S_(n-1)
* so the S_n = S_(n-1) + S_(n-2)
*
*
* */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /*** redo , 11/10/19***/
    public static int climbStairs2(int n){
        if (n == 0 || n == 1) return 1;
        int[] result = new int[n+1];// put case of 0 stairs there
        result[0] = 1;
        result[1] = 1;
        for(int i = 2; i < result.length; i++){
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];// the last digit of array
    }

    public static int climbStairs3(int n){
       if(n == 0|| n==1) {
           return 1;
       }else{
           return climbStairs3(n-1)+climbStairs3(n-2);
       }
    }

    public static void main(String[] args) {

        Assert.assertEquals("3 stairs 3 way",3,climbStairs3(3));

//        System.out.println("There are " +climbStairs3(stairs) + " ways to climb " + stairs + " stairs");

    }
}
