package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        int[] candidate = IntStream.range(1,10).toArray();
        backtrack(list,new ArrayList<>(),candidate,k,n,0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] candidate,int arrayLength, int remain, int start){
        if(remain < 0 || temp.size() > arrayLength) return;
        else if( remain == 0 && temp.size() == arrayLength){
            list.add(new ArrayList<>(temp));
        } else {
            for (int i = start ; i < candidate.length ; i++){
                temp.add(candidate[i]);
                backtrack(list,temp,candidate,arrayLength,remain - candidate[i],i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3,9));
    }

}
