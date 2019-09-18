package LeetCode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
    boolean ans = true;
    String temp = String.valueOf(x);
    for(int  i = 0 ; i < temp.length() ; i++){
        if (temp.charAt(i) != temp.charAt(temp.length()-1-i)){
            ans = false;
            break;
        }
    }
    return ans;
    }

    public static void main(String[] args) {
        int x = 10;
        PalindromeNumber test = new PalindromeNumber();
        System.out.println(test.isPalindrome(x));
    }
}
