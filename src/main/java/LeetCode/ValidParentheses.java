package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {

    /**** method 1 revert half of the ****/
    public static boolean isValid(String s) {
        // the length of string s has to be a even number
        if (s == null || s.length()%2 != 0) return false;



    }

    public static void main(String[] args) {
        String s = "([{";
        System.out.println(isValid(s));
    }
}
