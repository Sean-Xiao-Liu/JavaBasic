package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n > 0) backtrack(list,"",0,0,n);
        return list;
    }

    private static void backtrack(List<String> list, String temp,int open , int close, int length){
        if(temp.length() == 2*length){ // use length to measure the appearance
            list.add(temp);
        }

        if (open < length) // when count of ( smaller than 3
            backtrack(list, temp+"(", open+1, close, length); // add ( to temp and add 1 to the open count
        if (close < open) // when count of ) smaller than the count ( , add till the count match, used to make sure valid output
            backtrack(list, temp+")", open, close+1, length);
    }

    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));
    }
}
