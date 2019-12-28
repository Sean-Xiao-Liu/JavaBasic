package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class CustomSortString {
    public static String customSortString(String S, String T) {
        // turn S into a int array and use the array as comparator to sort T
        int[] index = new int[26]; // represent possible index of each character
        for (int i = 0; i < S.length(); ++i) {
            index[S.charAt(i) - 'a'] = i;
        }

//        // turn T into char array
////        char[] chars = T.toCharArray();

        Character[] characters = new Character[T.length()];
        for(int j = 0; j < T.length();j++){
            characters[j] = T.charAt(j);
        }

        // sort char array with index as comparator
//        Arrays.sort(characters,new Comparator<Character>(){
//
//            @Override
//            public int compare(Character c1, Character c2) {
//                return Integer.compare(index[c1 - 'a'] , index[c2 - 'a'] );
//            }
//        });
//      Comparator<Character> sortByIndex = (c1,c2) -> Integer.compare(index[c1 - 'a'] , index[c2 - 'a'] );

        Comparator<Character> sortByIndex = Comparator.comparingInt(c -> index[c - 'a']);
//        Comparator<Character> sortNatualOrder = Comparator.naturalOrder();

        Arrays.sort(characters,sortByIndex);
//        Arrays.sort(characters,sortNatualOrder);

       // convert sorted characters back to String
        StringBuilder stringBuilder = new StringBuilder();
        for(Character c : characters){
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main (String[] args){
        String S = "fedcba";
        String T = "babcdefx";

        System.out.println(customSortString(S,T));
    }
}
