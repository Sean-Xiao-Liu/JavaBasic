package LeetCode;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null) return new ArrayList<>(); // if strs is empty, return empty list
        Map<String,List> map = new HashMap<>();

        // transfer each string to char array and then sort
        for(String s : strs){ // can't use
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String keyString = new String(chars); // transfer char array to string

            //check if the map already contain the key
            // if does not contain the key, add
            if(map.containsKey(keyString)){
                map.get(keyString).add(s);
            } else {
                List<String> tempList = new ArrayList<>();
                map.put(keyString,tempList);
                map.get(keyString).add(s);
            }
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        String[] test = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(test));
    }
}
