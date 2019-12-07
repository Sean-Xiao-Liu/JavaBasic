package LeetCode;

import com.sun.jndi.toolkit.dir.ContextEnumerator;

import java.util.Iterator;
import java.util.Stack;

public class ReverseString {

    /***method 1 swap the head and tail***/
    public static void reverseString(char[] s) {
        int head = 0;
        int tail = s.length-1;
        while(head < tail){
            char temp = s[head];
            s[head] = s[tail];
            s[tail] = temp;
            head++;
            tail--;
        }
    }

    /***method 2 use stack***/
    public static void reverseString2(char[] s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length ; i++){
            stack.push(s[i]);
        }

        for(int i = 0 ; i < s.length; i++){
            s[i] = stack.pop();
        }

    }

    public static void main(String[] args) {
        char[] test = {'a','b','c'};
        reverseString2(test);
        for(int i = 0; i < test.length; i++){
            System.out.println(test[i]);
        }
    }
}
