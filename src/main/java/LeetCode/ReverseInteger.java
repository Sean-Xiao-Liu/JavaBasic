package LeetCode;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class ReverseInteger {
    /*** method 1 ***/
    public int reverse(int x) {
        int ans = 0;
        int newAns = 0;
        while(x != 0){
            int remainder = x%10; // eg. 123%10 = 3
            int quotient = x/10; // eg. 123/10 = 12
            x = quotient;
            newAns = ans * 10 + remainder; // move the last digit to the fr
            if((newAns - remainder)/10 !=  ans) return 0; // to prevent overflow
            ans = newAns;
        }
        return ans;
    }

    /*** method 1 v2 redo , 10/30/19 ***/
    public static int reverse2(int x){
        int ans = 0;
        int temp = 0;
        while (x != 0){
            int reminder = x % 10; // get the unit digit of int x
            int quotient = x / 10; // get all other digit of int x
            x = quotient; 
            temp = ans * 10 + reminder; // to create a new number
            if((temp - reminder)/10 != ans) return 0; // prevent overflow
            ans = temp;
        }
        return ans;
    }


    public static void main(String[] args) {
        ReverseInteger test = new ReverseInteger();
        System.out.println(test.reverse(-1230));
        System.out.println(reverse2(-543210));
    }
}
