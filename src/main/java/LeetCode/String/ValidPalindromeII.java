package LeetCode.String;

import java.util.Locale;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while(i < j){
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s){
        int i = 0, j = s.length()-1;
        while(i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s,int left, int right){
        while(left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII validPalindromeII = new ValidPalindromeII();
        System.out.println(validPalindromeII.validPalindrome("aba"));
    }
}
