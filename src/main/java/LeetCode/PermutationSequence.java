package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/*he set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"*/
public class PermutationSequence {

    // use backtracking to get a list of string then get kth element of the list
    public static String getPermutation(int n, int k) {
        int[] nums = IntStream.range(1,n+1).toArray(); // generate a Integer array as input of permutation
        List<StringBuilder> list = new ArrayList<>(); // have to use stringBuilder here since string object is immutable
        StringBuilder temp = new StringBuilder();
        backtrack(list,nums,temp);
        return list.get(k-1).toString();
    }

    private static void backtrack(List<StringBuilder> list,int[] nums,StringBuilder temp){
        if(temp.length() == nums.length){
            list.add(new StringBuilder(temp));
        } else {
            for(int i = 0; i < nums.length ; i++){
                if(temp.toString().contains(String.valueOf(nums[i]))) continue; // if the string builder contains the char then skip
                temp.append(nums[i]);
                backtrack(list,nums,temp);
                temp.deleteCharAt(temp.length()-1); // remove the last index of string builder after back tracking
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(9,2678));

//        StringBuilder word = new StringBuilder();
//        System.out.println(word.length());
//        word.append("ab");
//        word.append("c");
//        System.out.println(word.toString());
//
//        String word = "abs";
//        System.out.println(word.contains("a"));
    }

}
