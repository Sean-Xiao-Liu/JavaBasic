package LeetCode.String;

import java.lang.reflect.Array;
import java.util.*;

public class FindCommonCharacters {
    //    public static List<String> commonChars(String[] words) {
//        List<String> result = new ArrayList<>();
//
//        int length = words[0].length();
//
//        for(int j = 0 ; j < length ;j++){
//            String s = String.valueOf(words[0].charAt(j));
//            boolean flag = true;
//            for(int i = 1; i < words.length ;i++){
//                if(!words[i].contains(s)){
//                    flag = false;
//                    break;
//                } else {
//                    words[i] = words[i].replaceFirst(s,"");
//                }
//            }
//            if(flag) result.add(s);
//        }
//        return result;
//    }
    public List<String> commonChars(String[] words) {
        // Count characters in the first word
        int[] last = count(words[0]);

        // Update the count array by intersecting with each subsequent word
        for (int i = 1; i < words.length; i++) {
            last = intersection(last, count(words[i]));
        }

        // Build the result list based on the final count array
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = (char) ('a' + i);
                String s = String.valueOf(a);
                while (last[i] > 0) {
                    arr.add(s);
                    last[i]--;
                }
            }
        }
        return arr;
    }

    // Calculate the intersection of two count arrays
    private int[] intersection(int[] a, int[] b) {
        int[] t = new int[26];
        for (int i = 0; i < 26; i++) {
            t[i] = Math.min(a[i], b[i]);
        }
        return t;
    }

    // Count the frequency of each character in a word
    private int[] count(String str) {
        int[] t = new int[26];
        for (char c : str.toCharArray()) {
            t[c - 'a']++;
        }
        return t;
    }

    public static void main(String[] args) {
        String[] words = {"bella", "label", "roller"};
        FindCommonCharacters findCommonCharacters = new FindCommonCharacters();
        System.out.println(findCommonCharacters.commonChars(words));
    }
}
