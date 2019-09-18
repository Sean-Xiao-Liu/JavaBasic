package LeetCode;

public class ReverseInteger {
    public int reverse(int x) {
        int ans = 0;
        int newAns = 0;
        while(x != 0){
            int remainder = x%10; // eg. 123%10 = 3
            int quotient = x/10; // eg. 123/10 = 12
            x = quotient;
            newAns = ans * 10 + remainder;
            if((newAns - remainder)/10 !=  ans) return 0; // to prevent overflow
            ans = newAns;
        }
        return ans;
    }


    public static void main(String[] args) {
        ReverseInteger test = new ReverseInteger();
        System.out.println(test.reverse(-1230));
    }
}
