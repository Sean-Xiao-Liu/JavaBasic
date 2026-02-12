package LeetCode.Stack;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * 
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * 
 * The test cases are generated so that the length of the output will never exceed 105.
 * 
 * Example 1:   
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * 
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * 
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * 
 * Example 4:
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 *
 * Step-by-step walkthrough with input "3[a2[c]]":
 *
 * ch='3' -> digit: currentCount = 3
 *           countStack: []          resultStack: []          currentResult: ""
 *
 * ch='[' -> push count 3, push currentResult "", reset
 *           countStack: [3]         resultStack: [""]        currentResult: ""
 *
 * ch='a' -> letter: append to currentResult
 *           countStack: [3]         resultStack: [""]        currentResult: "a"
 *
 * ch='2' -> digit: currentCount = 2
 *           countStack: [3]         resultStack: [""]        currentResult: "a"
 *
 * ch='[' -> push count 2, push currentResult "a", reset
 *           countStack: [3, 2]      resultStack: ["", "a"]   currentResult: ""
 *
 * ch='c' -> letter: append to currentResult
 *           countStack: [3, 2]      resultStack: ["", "a"]   currentResult: "c"
 *
 * ch=']' -> pop count 2, innerContent = "c", pop result "a"
 *           currentResult = "a" + "c"*2 = "acc"
 *           countStack: [3]         resultStack: [""]        currentResult: "acc"
 *
 * ch=']' -> pop count 3, innerContent = "acc", pop result ""
 *           currentResult = "" + "acc"*3 = "accaccacc"
 *           countStack: []          resultStack: []          currentResult: "accaccacc"
 *
 * return "accaccacc"
 */
public class DecodeString {
    public String decodeString(String s) {
        // countStack stores the repeat count before each '['
        Stack<Integer> countStack = new Stack<>();
        // resultStack stores the previously built string before entering a new '[' scope
        Stack<StringBuilder> resultStack = new Stack<>();
        // currentResult accumulates characters for the current scope level
        StringBuilder currentResult = new StringBuilder();
        // currentCount builds multi-digit numbers (e.g. "12" -> 1*10+2 = 12)
        int currentCount = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // build the repeat count digit by digit (handles multi-digit like "12[a]")
                currentCount = currentCount * 10 + (ch - '0');
            } else if (ch == '[') {
                // save the current repeat count onto countStack for later use at ']'
                countStack.push(currentCount);
                // reset count for the next potential number inside the brackets
                currentCount = 0;
                // save the string built so far onto resultStack (this is everything before '[')
                resultStack.push(currentResult);
                // start a fresh StringBuilder to collect characters inside this '[' scope
                currentResult = new StringBuilder();
            } else if (ch == ']') {
                // pop the repeat count that was saved when we hit the matching '['
                int repeatCount = countStack.pop();
                // hold the content inside the brackets (what we just finished building)
                StringBuilder innerContent = currentResult;
                // pop the string that was being built before the '[' to continue appending to it
                currentResult = resultStack.pop();
                // append the inner content repeatCount times to the outer result
                while (repeatCount-- > 0) {
                    currentResult.append(innerContent);
                }
            } else {
                // regular letter: append to the current scope's result
                currentResult.append(ch);
            }
        }

        return currentResult.toString();
    }
}
