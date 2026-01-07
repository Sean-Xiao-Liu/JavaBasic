package LeetCode.Stack;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
//    public static String minRemoveToMakeValid(String s) {
//        int length = s.length();
//        Stack<Character> leftStack = new Stack<>();
//        Stack<Character> rightStack = new Stack<>();
//        StringBuilder result = new StringBuilder();
//
//        for(int i = 0 ; i < length; i++){
//            if (s.charAt(i) == '('){
//                leftStack.push(s.charAt(i));
//                result.append(s.charAt(i));
//            } else if (s.charAt(i) == ')'){
//                try{
//                    if (leftStack.peek() == '('){
//                        leftStack.pop();
//                        result.append(s.charAt(i));
//                    }
//                } catch (Exception e){
//
//                }
//            } else {
//                result.append(s.charAt(i));
//            }
//        }
//
//        for(int j = result.length()-1 ; j >= 0; j--){
//            if (result.charAt(j) == ')'){
//                rightStack.push(result.charAt(j));
//            }
//            if (result.charAt(j) == '('){
//                try{
//                    if (rightStack.peek() == ')'){
//                        rightStack.pop();
//                    }
//                } catch (Exception e){
//                    result.deleteCharAt(j);
//                }
//            }
//        }
//
//        return result.toString();
//    }

    public static String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        int openCount = 0;

        // Forward pass: mark invalid closing parentheses and count open parentheses
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                if (openCount == 0) {
                    chars[i] = '*'; // Mark invalid closing parenthesis
                } else {
                    openCount--;
                }
            }
        }

        // Backward pass: mark extra open parentheses
        for (int i = chars.length - 1; i >= 0 && openCount > 0; i--) {
            if (chars[i] == '(') {
                chars[i] = '*'; // Mark extra open parenthesis
                openCount--;
            }
        }

        // Construct result string
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (c != '*') {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "a)b(c)d";
        System.out.println(minRemoveToMakeValid(input));
    }
}
