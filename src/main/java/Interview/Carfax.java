package Interview;

import java.util.*;
import java.util.stream.Collectors;

public class Carfax {
    public static String findDuplicate(String inputString){
        int[] characters = new int[inputString.length()];
        int[] times = new int[26];
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0 ; i < inputString.length() ;i++){
            characters[i] = inputString.charAt(i) - 'a';
        }

        for(int j = 0 ; j < characters.length ; j++){
            times[characters[j]] += 1;
        }

        // then find max number in the array

        int max = times[0];

        for(int k = 0 ; k < times.length ; k++){
            if(times[k] > max) max = times[k];
        }

        // if max is 1 means no duplicate, return "no duplicate"
        if(max == 1) return "no duplicate";

        // if all times equals to max, means tie, return tie
        int countOfNumber = 0; // count all numbers
        int countOfMaxNumber = 0; // count the appearance times of max number
        for(int k = 0 ; k < times.length ; k++){
            if(times[k] == max){
                countOfMaxNumber++;
                stringBuilder.append((char)(k+97));
            }
            if(times[k] != 0) countOfNumber++; // all numbers
        }
        if(countOfMaxNumber == countOfNumber) return "tie"; // if all non-zero numbers are max means tie
        return stringBuilder.toString();

    }

    public static void main(String[] args) {

        System.out.println(findDuplicate("aaabbbccc"));
    }
}
