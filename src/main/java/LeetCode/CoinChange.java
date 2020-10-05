package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1*/
public class CoinChange {

    /** method 1 use backtracking to get all possible combination -> time limit exceed**/
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        List<List<Integer>> list  = new ArrayList<>();
        backtrack(list,new ArrayList<>(),coins,amount,0);
        int result = -1;
        if(list.size() == 0){
            return result;
        } else {
//            int temp = Integer.MAX_VALUE;
//            for(int i = 0 ; i < list.size() ; i++){
//                if(list.get(i).size() < temp){
//                    temp = list.get(i).size();
//                }
//            }
//            result = temp;
            result = list.stream().map(x -> x.size()).sorted().findFirst().get(); // use stream to get the smallest list size
        }



        return result;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] coins , int remain, int start){
        if(remain < 0) return;
        if(remain == 0){
            list.add(new ArrayList<>(temp));
        } else {
            for(int i = start ; i < coins.length ; i++){
                temp.add(coins[i]);
                backtrack(list,temp,coins,remain-coins[i],start);
                temp.remove(temp.size()-1);
            }
        }
    }

    /** method 2 dynamic programming **/
    public static int coinChange2(int[] coins, int amount) {
        int max = amount + 1;  // 使array index 于钱金额对应
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max); // dp[i] 对应的是凑成该金额所用最小硬币数
        dp[0] = 0; // fill the first index of array with 0 and this index will  not be updated/used
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) { // i 在这里是钱的金额，而不是index
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);// dp[i] 和 dp[i - coins[j]] 相差一枚价值为coins[j] 的硬币
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount]; //if not able to make it the dp[amount] would equals max, which is larger than amount,then return -1
    }

    public static void main(String[] args) {
        int[] coins = {2,3};
        System.out.println(coinChange2(coins,11));
    }
}
