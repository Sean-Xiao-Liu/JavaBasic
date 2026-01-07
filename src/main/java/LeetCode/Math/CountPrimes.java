package LeetCode.Math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Count the number of prime numbers less than a non-negative number, n.
public class CountPrimes {
    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)){
                count++;
                System.out.println(i);
            }
        }
        return count;
    }

    public static boolean isPrime(int num){
        if (num <= 1) return false;
        // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static int countPrimes2(int n) {
        //Sieve
        if (n <= 2) return 0;
        boolean sieve[] = new boolean[n+1];
        sieve[2] = true;
        for(int i = 3; i < n; i+=2) {
            sieve[i] = true;
        }

        for (int p = 3; p*p<=n; p++){
            if (sieve[p]){
                for (int i = p+p; i<=n; i += p ){
                    sieve[i] = false;
                }
            }
        }
        int count = 1;
        for (int i = 3; i < n; i+=2){
            count += sieve[i] ? 1:0;
        }
        return count;
    }

    public static void main(String[] args) {
        int test = 100;
//        int result = countPrimes(test);
        int result2 = countPrimes2(test);
        System.out.println("There are "+result2 + " primees within "+ test );
    }
}
