package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HappyNumber {
    /** method 1**/
    public static boolean isHappy(int n) {
        Map<Integer,Integer> map = new HashMap<>(); // use map to record if duplicated number show up
        while( n != 1) {
//            System.out.println(n);
            if (map.containsKey(n)) { // means loop occurs, it is not happy number then return false
                return false;
            } else {
                map.put(n, 1);
                n = transfer(n);
            }
        }
        return true; // if come out the while loop , means n is 1 , return true
    }



    private static int transfer(int n){
        int temp = 0;
        while(n != 0){
            int res = n % 10; // take the unit digit
            temp = temp + res * res;
            n = n / 10;
        }
        return temp;
    }

    /** method 2 use fast and slow pointer instead of map to track possible loop**/
    public static boolean isHappy2(int n) {
        if (n <= 0) {
            return false;
        }
        int slow = n;
        int fast = transfer(n);  // setting fast to n would cause an immediate `slow == fast` collision

        while (fast != 1 && slow != fast) {
            slow = transfer(slow);
            fast = transfer(fast);
            fast = transfer(fast);
        }

        return fast == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy2(20));
    }
}
