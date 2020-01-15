package Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Armedia {
    public static List<List<Integer>> combinationSum3(int[] candidate,int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
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

        int[] candidate = {3,4,6,7,10,3,9,15,17,17, -5, 10,7, -1, 21};
        int target = 20;
        int k = 2;
        System.out.println(combinationSum3(candidate,4,20));

    }
}
