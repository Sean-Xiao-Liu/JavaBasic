package Algorithm;

import sun.misc.ClassFileTransformer;

import java.util.Arrays;
import java.util.Comparator;

public class SortCharacterArray {
    public static void sortCharacterArray(Character[] characters){
        Arrays.sort(characters, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public static void main(String[] args) {
        Character[] characters = {'e','d','c','b','a'};
        sortCharacterArray(characters);
        for(Character c : characters){
            System.out.println(c);
        }
    }
}
