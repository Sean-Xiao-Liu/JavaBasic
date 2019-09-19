package LeetCode;

public class PalindromeNumber {



    public boolean isPalindrome(int x) {
//    //method 1 trans int to string, traversal and compare the head and tail of the string
//    boolean ans = true;
//    String temp = String.valueOf(x);
//    for(int  i = 0 ; i < temp.length() ; i++){
//        if (temp.charAt(i) != temp.charAt(temp.length()-1-i)){
//            ans = false;
//            break;
//        }
//    }
//    return ans;



        // method 2 reverse the int and compare the new int with the old one
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // similar to the Reverse Integer Problem
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }

    public static void main(String[] args) {
        int x = 10;
        PalindromeNumber test = new PalindromeNumber();
        System.out.println(test.isPalindrome(x));
    }
}
