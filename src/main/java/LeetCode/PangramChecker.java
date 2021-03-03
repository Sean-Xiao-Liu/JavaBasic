package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * A pangram is a sentence containing every letter in the English Alphabet (a-z).
 */
public class PangramChecker {
    public boolean PangramChecker(String string){
        // first convert all chars in string to lowercase
        string = string.toLowerCase();

        // to store the check result
        boolean[] booleans = new boolean[26];

        for(int i = 0 ; i < string.length();i++){
            if(string.charAt(i) - 'a' >= 0 && string.charAt(i) - 'a' <= 25){ // ignore special chars
                int index = string.charAt(i) - 'a'; // get corresponding index of char
                if(booleans[index] == false) booleans[index] = true; // mark the index as checked
            }
        }

        for (boolean b:booleans){
            if (b == false) return false; // if there is one false in the booleans array, means the char is missing
        }
        return true;
    }

    public List<Character> FindMissingChars(String string){
        string = string.toLowerCase();
        List<Character> list = new ArrayList<>();

        // to store the check result
        boolean[] booleans = new boolean[26];

        for(int i = 0 ; i < string.length();i++){
            if(string.charAt(i) - 'a' >= 0 && string.charAt(i) - 'a' <= 25){ // ignore special chars
                int index = string.charAt(i) - 'a'; // get corresponding index of char
                if(booleans[index] == false) booleans[index] = true; // mark the index as checked
            }
        }

        for (int i = 0 ; i < booleans.length;i++){
            if (booleans[i] == false){
                char temp = (char) ((int)'a'+ i);
                list.add(temp);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        PangramChecker p = new PangramChecker();
        System.out.println("The quick brown fox jumps over the lazy dog is a Pangram?"
                + p.PangramChecker("The quick brown fox jumps over the lazy dog"));

        System.out.println("Pack my box with five dozen liquor jug is a Pangram?"
                + p.PangramChecker("Pack my box with five dozen liquor"));

        System.out.println(p.FindMissingChars("Pack my box with five dozen liquor"));
    }
}
