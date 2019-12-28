package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // sort is necessary here
        backtrack(list,new ArrayList<>(),nums,new boolean[nums.length]); // the length of array needs to be given at claim time
        return list;
    }

    /* Add check point here to check if the number has been used, this is different
     * compare to the permutation
     */
    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, boolean[] used){
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
        } else {
            for(int i = 0 ; i < nums.length ; i++){
                /* either used[i] or  (i > 0 && nums[i] == nums[i-1] && !used[i - 1]) is true
                 * skip the rest steps
                 */
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                temp.add(nums[i]);
                backtrack(list, temp, nums, used);
                used[i] = false; // when move back, change the used from true to false
                temp.remove(temp.size() - 1); // remove the last index
            }
        }

    }

    public static void main(String[] args) {
        int[] test = {1,1,2,1};
        System.out.println(permuteUnique(test));
    }
}
