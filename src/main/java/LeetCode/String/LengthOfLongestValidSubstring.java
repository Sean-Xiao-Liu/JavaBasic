package LeetCode.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfLongestValidSubstring {
//    public int longestValidSubstring(String word, List<String> forbidden) {
//        int left = 0, right = 1, res = 0;
//        while(right <= word.length()) {
//            String s = word.substring(left,right);
//            if(isValid(s,forbidden)){
//                res = Math.max(res,s.length());
//                right++;
//            } else {
//                left++;
//                right++;
//            }
//        }
//        return res;
//    }
//
//    private boolean isValid(String sub, List<String> forbidden) {
//        for(String s:forbidden){
//            if(sub.indexOf(s) != -1) return false;
//        }
//        return true;
//    }

    public int longestValidSubstring(String word, List<String> forbidden) {
        int length = 0;

        Set<String> forbiddenSet = new HashSet<>();
        for (String s : forbidden) {
            forbiddenSet.add(s);
            length = Math.max(length, s.length()); // get length of max forbidden word, which is between 1 and 10
        }

        int n = word.length();
        int result = 0;
        for (int i = n - 1, right = n; right > result && i >= 0; --i) {
            StringBuilder temp = new StringBuilder();
            for (int j = i; j < right && j - i < length; ++j) {
                temp.append(word.charAt(j));
                if (forbiddenSet.contains(temp.toString())) {
                    right = j;
                    break;
                }
            }
            result = Math.max(result, right - i);
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestValidSubstring l = new LengthOfLongestValidSubstring();
        List<String> forbidden = new ArrayList<>();
        forbidden.add("aaa");
        forbidden.add("cb");
        System.out.println(l.longestValidSubstring("cbaaaabc",forbidden));
    }
}
