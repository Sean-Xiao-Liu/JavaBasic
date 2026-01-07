package LeetCode.String;

import java.util.HashMap;

public class RomanToInteger {
    //method 1 brutal force
    public static int romanToInt(String s) {
//        int ans = 0;

//        // traversal from left to the right except the last index
//        // list all six instances where subtraction is used
//        for(int i = 0 ; i < s.length()-1 ; i++){
//            if(s.charAt(i) == 'I' && s.charAt(i+1) != 'V' && s.charAt(i+1) != 'X') ans += 1;
//            if(s.charAt(i) == 'I' &&  (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) ans -= 1;
//            if(s.charAt(i) == 'V' ) ans += 5;
//            if(s.charAt(i) == 'X' && s.charAt(i+1) != 'L' && s.charAt(i+1) != 'C') ans += 10;
//            if(s.charAt(i) == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) ans -= 10;
//            if(s.charAt(i) == 'L') ans += 50;
//            if(s.charAt(i) == 'C' && s.charAt(i+1) != 'D' && s.charAt(i+1) != 'M') ans += 100;
//            if(s.charAt(i) == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) ans -= 100;
//            if(s.charAt(i) == 'D') ans += 500;
//            if(s.charAt(i) == 'M') ans += 1000;
//        }
//
//        // check the last index
//        for(int j = s.length()-1; j == s.length()-1 ; j--){
//            if(s.charAt(j) == 'I') ans += 1;
//            if(s.charAt(j) == 'V') ans += 5;
//            if(s.charAt(j) == 'X') ans += 10;
//            if(s.charAt(j) == 'L') ans += 50;
//            if(s.charAt(j) == 'C') ans += 100;
//            if(s.charAt(j) == 'D') ans += 500;
//            if(s.charAt(j) == 'M') ans += 1000;
//        }
//
//        return ans;

        // method 2
        // creat a new hash map to save char-int(key,value) pair
        // a little slow since hash map involved
        HashMap<Character , Integer> map = new HashMap<Character, Integer>();
        map.put('I' , 1);
        map.put('V' , 5);
        map.put('X' ,10);
        map.put('L' , 50);
        map.put('C' , 100);
        map.put('D' , 500);
        map.put('M' , 1000);
        char[] chars = s.toCharArray();
        int result = 0;
        int i = 0, j = 1;
        for(; j < chars.length; i++, j++) { //Multiple Initializers and incrementers, checked every index except the last one
            if (map.get(chars[i]) >= map.get(chars[j])) {
                result += map.get(chars[i]); // eg 5 > 1 => result += 5
            } else {
                result -= map.get(chars[i]); // eg 1 < 5 => result -= 1
            }
        }
        result += map.get(chars[i]);
        return result;
    }









    /*** method 2 redo , 11/9/19***/

    public static int romanToInt2(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I' , 1);
        map.put('V' , 5);
        map.put('X' ,10);
        map.put('L' , 50);
        map.put('C' , 100);
        map.put('D' , 500);
        map.put('M' , 1000);

        int i = 0 , j = 1 , result = 0;
        char[] chars = s.toCharArray();
        for(;j<chars.length;i++,j++){
            if(map.get(chars[i])>map.get(chars[j])){
                result += map.get(chars[i]);
            } else {
                result -= map.get(chars[i]);
            }
        }
        result += map.get(chars[i]);
        return result;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println("The number is " + romanToInt(s));
        System.out.println("The number is " + romanToInt2(s));
//        System.out.println(s.toCharArray()[1]);
    }

}
