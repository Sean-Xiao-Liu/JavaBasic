package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int[] candidate = IntStream.range(1,n+1).toArray();
        backtrack(list,new ArrayList<>(),candidate,k,0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] candidate, int arrayLength,int start){
        if(temp.size() == arrayLength){
            list.add(new ArrayList<>(temp));
        } else {
            for(int i = start ; i < candidate.length ; i++){
//                if(temp.contains(candidate[i])) continue; // since start position moves and there is no duplicate number in the array
                temp.add(candidate[i]);
                backtrack(list,temp,candidate,arrayLength,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
}
