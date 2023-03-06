package LeetCode;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {

        if(s.length() == 0 || s.length() == 1) return true;
        //transfer the the string to lower case
        s = s.toLowerCase();

        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i< s.length() ; i++){
            if(s.charAt(i) - 'a' >= 0 ||(s.charAt(i) - 'a' >= -49 && s.charAt(i) - 'a' <= -40)) list.add(s.charAt(i) - 'a');
        }

        List<Integer> temp = new ArrayList<>();
        for (int j = 0 ; j < list.size() ; j++){
            temp.add(list.get(j));
        }
        Collections.reverse(list);
        return temp.equals(list) ;
    }

    public static void main(String[] args) {
        String test = "0A man, a plan, a canal: Panama0";
        System.out.println(isPalindrome(test));
        System.out.println('9' - 'a');
    }
}
