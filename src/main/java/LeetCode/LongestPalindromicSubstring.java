package LeetCode;
/*Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"*/
public class LongestPalindromicSubstring {

    /** method 1 brutal force, list all possible **/
    public static String longestPalindrome(String s) {
        String result = "";
        for(int i = 0 ; i < s.length();i++){
            for(int j = i+1 ; j <= s.length();j++){
                String temp = s.substring(i,j);
                if(isPalindrome(temp) && temp.length() > result.length()){
                    result = temp;
                }
            }
        }
        return result;
    }

//     method to check if the string is valid palindrome
    private static boolean isPalindrome(String string){
        String reversed = new StringBuilder(string).reverse().toString();
        return string.equals(reversed);
    }

    /** method 2 extend the palindrome from each char**/

    public static String longestPalindrome2(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extend(s, i, i), s2 = extend(s, i, i + 1); // s1 for case of odd string length while s2 for even string length case
            if (s1.length() > max.length()) max = s1;
            if (s2.length() > max.length()) max = s2;
        }
        return max;
    }

    private static String extend(String s, int i, int j) {
        for (; 0 <= i && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) break;
        }
        return s.substring(i + 1, j); // i might be -1 after  for loop
    }

    public static void main(String[] args) {
        String word = "acbbbca";
        System.out.println(longestPalindrome2(word));
    }
}
