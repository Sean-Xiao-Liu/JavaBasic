package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {

        if(s.length() == 1) return 0;
        if(s == null) return -1;

        Map<Character, Integer> map = new LinkedHashMap<>(); // since the order of key matters
        for(int i = 0; i < s.length() ; i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
//
            }
        }

        if(!map.containsValue(1)) return -1;

        Character character = null;

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() == 1){
                character = entry.getKey();
                break;
            }
        }

        int result = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if (s.charAt(i) == character){
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String string = "loveleetcode";
        System.out.println(firstUniqChar(string));
    }
}
