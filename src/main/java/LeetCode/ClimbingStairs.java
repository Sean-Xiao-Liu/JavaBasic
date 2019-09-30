package LeetCode;


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

    public static void main(String[] args) {
        int stairs = 10;
        System.out.println("There are " +climbStairs(stairs) + " ways to climb " + stairs + " stairs");
    }
}
