package LeetCode;

import java.util.*;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * **/
public class LongestSubstringWithoutRepeatingCharacters {
    /*** method 1 brutal force with time complexity O(n^2) ***/
//    public static int lengthOfLongestSubstring(String s) {
//        // create a new list to store the length of each valid substring
//        if(s.length() == 0 || s.length() == 1) return s.length();
//
//        List<Integer> list = new ArrayList<>();
//
//        for ( int i = 0; i < s.length(); i++){
//            Map<Character,Integer> map = new HashMap<>();
//            for(int j = i; j < s.length(); j++){
//            int previousSize = map.size();
//            map.put(s.charAt(j),j);
//            int afterSize = map.size();
//                if(previousSize == afterSize){ //when the previous and after size are equals, it means that there is a duplicate
//                    list.add(afterSize);
//                    break;
//                } if(j == s.length() -1){ // if there is no duplicate until the last character of the string, make sure to add the length of substring into the arraylist
//                    list.add(afterSize);
//                }
//            }
//        }
//        return Collections.max(list);
//    }
//
//    /*** method 2 sliding window***/
//    // the time complexity would be O(n) since only traverse once
//    public static int lengthOfLongestSubstring2(String s) {
//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0, i = 0, j = 0;
//        while (i < n && j < n) { // i is the left bound, j is the right bound, if the char is not duplicated, move the right bound, else, move left bound
//            // try to extend the range [i, j]
//            if (!set.contains(s.charAt(j))){ // if set doesn't contains char at right bound
//                set.add(s.charAt(j++)); // add charAt(j), then j++, which move the right bound
//                ans = Math.max(ans, j - i);// find the max distance between the fast and slow pointer
//            }
//            else {
//                set.remove(s.charAt(i++)); // remove charAt(i), then i++, which move the left bound, this will keep deleting until the chat at j is removed from set
//            }
//        }
//        return ans;
//    }

    public static int lengthOfLongestSubstring(String s){
        if (s.length() == 0 || s.length() == 1) return s.length();
        int left = 0, right = 0, res = 0;
        int length = s.length();
        Set<Character> set = new HashSet<>();
        while(left < length && right < length){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                res = Math.max(res,set.size());
            } else {
                set.remove(s.charAt(left++));
            }

        }
        return res;
    }




    public static void main(String[] args) {
        String s = "lakjsdfalkasjdf";
        System.out.println(lengthOfLongestSubstring(s));
//        System.out.println(lengthOfLongestSubstring(s));
//        System.out.println(s.length());
//        System.out.println(s.substring(1,15));
    }
}

