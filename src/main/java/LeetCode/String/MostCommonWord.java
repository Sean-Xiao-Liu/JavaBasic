package LeetCode.String;


/*
*
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.



Example:

Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.*/



import java.util.*;

public class MostCommonWord {

    /** method 1 map **/
    public static String mostCommonWord(String paragraph, String[] banned) {
        // split the string to string array
        String[] words = paragraph.toLowerCase() //
                .split("[!?',;.\\s*]+");

        List<String> bannedList = Arrays.asList(banned);
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < words.length ; i++){
            if(!bannedList.contains(words[i])){
                map.put(words[i],map.getOrDefault(words[i],0)+1);
            }
        }

        String result = "";
        int mostCommon = map.values().stream().max(Integer::compare).get();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(mostCommon)) {
                result = entry.getKey().toString();
            }
        }
        return result;
    }

    /** method 2 map + update count part **/
    public static String mostCommonWord2(String paragraph, String[] banned) {
        // split the string to string array
        String[] words = paragraph.toLowerCase() //
                .split("[!?',;.\\s*]+");

        String result = "";
        int count = Integer.MIN_VALUE;

        List<String> bannedList = Arrays.asList(banned);
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < words.length ; i++){
            if(!bannedList.contains(words[i])){
                map.put(words[i],map.getOrDefault(words[i],0)+1);
                if (map.get(words[i]) > count){
                    count = map.get(words[i]);
                    result = words[i];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println( mostCommonWord2(paragraph,banned));
    }
}
