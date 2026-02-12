package LeetCode.Stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * You are given a string s, which contains stars *.
 * 
 * In one operation, you can:
 * 
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star
 * itself.
 * Return the string after all stars have been removed.
 * 
 * Note:
 * 
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 */
public class RemovingStarsFromAString {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '*') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) { // can iterate the stack directly
            sb.append(ch);
        }
        return sb.toString();
    }

    // two-pointer approach: use slow as a write pointer (simulates stack top)
    public String removeStars2(String s) {
        char[] array = s.toCharArray();
        int slow = 0; // slow acts as the write index (like stack top)
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] != '*') {
                array[slow] = array[fast]; // write non-star char at slow position
                slow++;
            } else {
                slow--; // star removes the previous character by moving slow back
                // and would write over the previous character if it's not a star later
            }
        }
        return new String(array, 0, slow); // chars from 0 to slow are the result
    }

    public static void main(String[] args) {
        RemovingStarsFromAString solution = new RemovingStarsFromAString();
        String s = "abb*cdfg*****x*";
        // System.out.println(solution.removeStars(s));
        System.out.println(solution.removeStars2(s));
    }
}
