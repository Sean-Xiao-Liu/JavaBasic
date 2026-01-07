package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,new ArrayList<>(), candidates,target,0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] candidates, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0){
            list.add(new ArrayList<>(temp));
        } else {
            for(int i = start; i < candidates.length ; i++){
                if(i > start && candidates[i] == candidates[i-1]) continue; // skip duplicates
                temp.add(candidates[i]);
                backtrack(list,temp,candidates,remain - candidates[i], i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(test,8));
    }
}
