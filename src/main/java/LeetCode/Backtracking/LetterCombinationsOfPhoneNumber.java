package LeetCode.Backtracking;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        Map<String,String> map = new HashMap<>(); // use String as key to use subString method
        List<String> list = new ArrayList<>(); // list to store the output strings
        String combination = "";
        // add key value pair to the map for look up later
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        if (digits.length() != 0) backtrack(list,map,combination,digits); // if the digit is null then the output should be an empty list

        return list;
    }

    private static void backtrack(List<String> list, Map<String,String> map ,String combination, String nextDigit){
        if (nextDigit.length() == 0){ // when no next digit, means all the digits have been iterated
            list.add(combination);
        } else {
            String digit = nextDigit.substring(0,1); // take the 1st digit in the nextDigit as a string
            String characters = map.get(digit); // get corresponding charac

            for(int i = 0 ; i < characters.length() ; i++){
                String character = characters.substring(i,i+1); //get ith letter
                backtrack(list,map,combination+character,nextDigit.substring(1));// remove 1st index in digit
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
