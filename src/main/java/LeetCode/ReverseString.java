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

    /***method 3 use recursion ***/
    public static String reverseString3(String string)
    {
        if (string.isEmpty()){
            return string;
        }
        //Calling function recursively
        return reverseString3(string.substring(1)) + string.charAt(0);
    }




    public static void main(String[] args) {
        String blogName = "How To Do In Java ";

        String reverseString = reverseString3(blogName);

        System.out.println(reverseString);

    }
}
