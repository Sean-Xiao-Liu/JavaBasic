package LeetCode;

public class PowerOfNumber {

    /** method 1 brutal recursive*/
    public static double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        if( n >= 0){
            return myPow(x,n-1) * x;
        } else {
            return myPow(x, n+1) / x;
        }
    }

    /** method 2 */
    // make n
    public static double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        // the target is use power to get n quickly
        // x^10 = ((x * x)^2 * x)^2
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product; // if i can't divided by 2, times x
            }
            current_product = current_product * current_product; // if i can divided by 2, square the result
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow2(2,10));
    }
}
