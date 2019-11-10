package LeetCode;

import java.util.*;

public class ValidParentheses {


    public static boolean isValid(String s) {


        // the length of string s has to be a even number (or empty)


        /**** method 1 revert half of the ****/
        // mapping
//        if (s.length()%2 != 0) return false;



        /**** method 2 use stack ****/
//        if (s.length()%2 != 0) return false;
//        char temp = ' ';
//        Stack<Character> stack = new Stack<Character>();
//        for (int i = 0 ; i < s.length() ; i++){
//            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
//                stack.push(s.charAt(i)); // save the the left side of parentheses to the stack
//            }
//            if(s.charAt(i) == ')'){
//                try { // use try catch in case the stack is empty
//                    temp = stack.pop();
//                    if (temp != '(') return false;
//                } catch (Exception e){
//                    return false;
//                }
//            }
//            if(s.charAt(i) == ']'){
//                try {
//                    temp = stack.pop();
//                    if(temp != '[') return false;
//                } catch (Exception e){
//                    return false;
//                }
//            }
//            if(s.charAt(i) == '}'){
//                try {
//                    temp = stack.pop();
//                    if (temp != '{') return false;
//                } catch (Exception e){
//                    return false;
//                }
//            }
//        }
//
//        if(stack.size() != 0) return false;
//
//        return true;

        /**** updated method 2****/
        if (s.length()%2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                if(c == '(' ) stack.push(')');
                if(c == '{' ) stack.push('}');
                if(c == '[' ) stack.push(']');
            } else {
                if(stack.isEmpty()) return false; // right parentheses comes first, which is false
                if(c != stack.pop()) return false; // pop will be executed
            }
        }
        return (stack.empty()) ? true : false; //
    }


    /*** method 2 redo , 11/10/19***/
    public static boolean isValid2(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                if (c == '(') stack.push(')');
                if (c == '[') stack.push(']');
                if (c == '{') stack.push('}');
            } else {
                if (stack.isEmpty()) return false;
                if (c != stack.pop()) return false;
            }
        }
        return (stack.isEmpty()) ? true:false;
    }


    public static void main(String[] args) {
        String s = "({[})]";
        System.out.println(isValid(s));
        System.out.println(isValid2(s));
    }
}
