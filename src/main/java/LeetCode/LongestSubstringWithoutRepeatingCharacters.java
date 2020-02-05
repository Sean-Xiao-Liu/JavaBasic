package LeetCode;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    /*** method 1 brutal force with time complexity O(n^2) ***/
    public static int lengthOfLongestSubstring(String s) {
        // create a new list to store the length of each valid substring
        if(s.length() == 0 || s.length() == 1) return s.length();

        List<Integer> list = new ArrayList<>();

        for ( int i = 0; i < s.length(); i++){
            Map<Character,Integer> map = new HashMap<>();
            for(int j = i; j < s.length(); j++){
            int previousSize = map.size();
            map.put(s.charAt(j),j);
            int afterSize = map.size();
                if(previousSize == afterSize){ //when the previous and after size are equals, it means that there is a duplicate
                    list.add(afterSize);
                    break;
                } if(j == s.length() -1){ // if there is no duplicate until the last character of the string, make sure to add the length of substring into the arraylist
                    list.add(afterSize);
                }
            }
        }
        return Collections.max(list);
    }

    /*** method 2 sliding window***/
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++)); // add charAt(j), then j++, which move the right bound
                ans = Math.max(ans, j - i);// find the max distance between the fast and slow pointer
            }
            else {
                set.remove(s.charAt(i++)); // remove charAt(i), then i++, which move the left bound
            }
        }
        return ans;
    }





    public static void main(String[] args) {
        String s = "lakjsdflkasjdf";
//        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring2(s));
    }
}

