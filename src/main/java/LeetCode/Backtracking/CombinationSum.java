package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list  = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list,new ArrayList<>(),candidates,target,0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> temp , int[] candidates, int remain, int start){
        if(remain < 0) return; // if remain < 0 means the sum of the temp array is too large
        else if(remain == 0) list.add(new ArrayList<>(temp));
        else {
            for(int i = start ; i < candidates.length ; i++){
                temp.add(candidates[i]);
                backtrack(list,temp,candidates,remain-candidates[i],i);/**start is not i + 1 because we can reuse same elements*/
                temp.remove(temp.size()-1); // remove last digit for back tracking
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] test = {2,3,6,7};
        System.out.println(combinationSum.combinationSum(test,7));
    }
}
