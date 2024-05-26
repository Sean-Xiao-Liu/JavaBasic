package LeetCode;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public static String minRemoveToMakeValid(String s) {
        int length = s.length();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(int i = 0 ; i < length; i++){
            if (s.charAt(i) == '('){
                leftStack.push(s.charAt(i));
                result.append(s.charAt(i));
            } else if (s.charAt(i) == ')'){
                try{
                    if (leftStack.peek() == '('){
                        leftStack.pop();
                        result.append(s.charAt(i));
                    }
                } catch (Exception e){

                }
            } else {
                result.append(s.charAt(i));
            }
        }

        for(int j = result.length()-1 ; j >= 0; j--){
            if (result.charAt(j) == ')'){
                rightStack.push(result.charAt(j));
            } else if (result.charAt(j) == '('){
                try{
                    if (rightStack.peek() == ')'){
                        rightStack.pop();
                    }
                } catch (Exception e){
                    result.deleteCharAt(j);
                }
            } else {

            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "a)b(c)d";
        System.out.println(minRemoveToMakeValid(input));
    }
}
