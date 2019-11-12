package LeetCode;

import java.util.Arrays;

public class ShortestSubstring {
    /***
     * Given a string, find the smallest window length with all distinct characters of the given string. For eg. str = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca” .

     Examples:

     Input  : aabcbcdbca
     Output : dbca
     Explanation :
     dbca of length 4 is the smallest
     window with highest number of distinct
     characters.

     Input : aaab
     Output : ab
     Explanation :
     ab of length 2 is the smallest window
     with highest number of distinct characters.
     ***/

    // define the number of possible distinct chars
    static final int MAXCHARS = 256;
    public static String shortestSubstring(String str){

        // count all distinct characters in the given string
        int stringLength = str.length();
        boolean[] visited = new boolean[MAXCHARS];
        int distinctCount = 0 ;
        for(int i = 0 ; i < stringLength ; i++){
            if(visited[str.charAt(i)] == false) {
                visited[str.charAt(i)] = true;
                distinctCount++;
            }
        }





        return "lol";

    }

    public static void main(String[] args) {
        String test = "abbac";
        System.out.println(shortestSubstring(test));
    }
}
