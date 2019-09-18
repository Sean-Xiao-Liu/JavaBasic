package Algorithm;

public class Fibonacci {

    // method 1
    public static int fib(int n){
        if(n == 0){
            return 1;
        }

        if(n == 1){
            return 2;
        }

        return fib(n-1)+fib(n-2);
    }

    // method 2 recursive + memo
    public static int fib2(int n, int[] memo){

        if(n == 0){
            return 1;
        }

        if(n == 1){
            return 2;
        }

        if(memo[n] != 0 ) {
            return memo[n];
        }

        memo[n] = fib2(n-1,memo)+fib2(n-2,memo);
        return memo[n];
    }

    // method 3
    public static int fib3(int n){
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 2;
        for (int i = 2; i <= n; i++ ){
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[n];
    }


    public static void main(String[] args) {
//        System.out.println(fib(51));
//        int[] memo = new int[51];
//        System.out.println(fib2(50,memo));
        System.out.println(fib3(5));
    }
}
