package LeetCode.String;



import java.util.*;

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

    // overloading
    public static String reverseString(String str){
        char[] chars = str.toCharArray(); //convert to char array
        int head = 0;
        int tail = chars.length-1;
        while(head < tail){
            char temp = chars[tail];
            chars[tail] = chars[head];
            chars[head] = temp;
            head++;
            tail--;
        }
       return String.valueOf(chars);
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

    /** method 4 swap based on the index */
    public static String reverseString4(String string){
        int length = string.length();
        char[] chars = new char[length];
        for(int i = 0;i < length ; i++){
            chars[i] = string.charAt(length-i-1);
        }
        return new String(chars);
    }



    /**method 5 use StringBuilder*/
    public static String reverseString5(String string){
        String result = new StringBuilder(string).reverse().toString();
        return result;
    }

    /**reverse each word in a string */
    public static String reverseWordsInString(String str){
        String[] words=str.split(" ");// split the string into a String array
        String reverseWord = "";
        for(String w:words){
            StringBuilder sb=new StringBuilder(w);
            sb.reverse();
            reverseWord += sb.toString()+" ";
        }
        return reverseWord.trim();// trim() returns a string whose value is this string, with any leading and trailing whitespace removed.
    }



    public static void main(String[] args) {
        String blogName = "How To Do In Java";

        String reverseString = reverseString3(blogName);
//        String reverseWord = reverseWordsInString(blogName);

        System.out.println(reverseString);
//        System.out.println(reverseWord);

    }
}
