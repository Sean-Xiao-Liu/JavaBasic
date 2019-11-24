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

    public static String shortestSubstring(String str){

        // count all distinct characters in the given string

        final int MAXCHARS = 256;
        int stringLength = str.length();
        boolean[] visited = new boolean[MAXCHARS];
        int distinctCount = 0 ;
        for(int i = 0 ; i < stringLength ; i++){
            if(visited[str.charAt(i)] == false) {
                visited[str.charAt(i)] = true;
                distinctCount++;
            }
        }

        //start
        int start = 0, start_index = -1;
        int min_len = Integer.MAX_VALUE;

        int count = 0;
        int[] curr_count =  new int[MAXCHARS];

        for (int j=0; j<stringLength; j++)
        {
            // Count occurrence of characters of string
            curr_count[str.charAt(j)]++;

            // If any distinct character matched,
            // then increment count
            if (curr_count[str.charAt(j)] == 1 ) // if the char showed up for the first time
                count++; // count how many distinct characters have showed up already.

            // if all the characters are matched
            if (count == distinctCount)
            {
                // Try to minimize the window i.e., check if
                // any character is occurring more no. of times
                // than its occurrence in pattern, if yes
                // then remove it from starting and also remove
                // the useless characters.
                while (curr_count[str.charAt(start)] > 1) // start is the first index of the given string
                {
                    if (curr_count[str.charAt(start)] > 1)
                        curr_count[str.charAt(start)]--;
                    start++;
                }

                // Update window size
                int len_window = j - start + 1;
                if (min_len > len_window)
                {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }
        // Return substring starting from start_index
        // and length min_len
        return str.substring(start_index, start_index+min_len);

    }

    public static void main(String[] args) {
        String test = "aaaabbac";
        System.out.println(shortestSubstring(test));
    }
}
