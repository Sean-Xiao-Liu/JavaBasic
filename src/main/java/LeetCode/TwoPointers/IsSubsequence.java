package LeetCode.TwoPointers;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false
 * otherwise.
 * 
 * A subsequence of a string is a new string that is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (i.e., "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * Example 1:
 * 
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 * 
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 100
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        /**
         * These are correct but redundant. If you simplify the return to return i == s.length():
            s is empty → i == 0 == s.length() → returns true ✅
            t is empty, s is not → loop never runs, i == 0 != s.length() → returns false ✅
         */
        // if (s.length() == 0 && t. length() >= 0 ) return true;
        // if (s.length() != 0 && t.length() == 0 ) return false;

        while (i < s.length() && j < t.length()) { // should end if one of the string reach to the end
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        /**
         * The extra s.charAt(i - 1) == t.charAt(j - 1) check is unnecessary. If i == s.length(), 
         * that means every character in s was already matched in the loop — you don't need to verify the last character again.
         */
        // only return true if s reach the end and s[i-1] = t[j-1]
        // return (i == s.length() && s.charAt(i - 1) == t.charAt(j - 1)) ? true : false;
        return i == s.length();
    }

}
