package LeetCode.DynamicProgramming;

import java.util.*;

/**
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 */
public class CoinChangeTwo {

    /** method 1 backtracking **/
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        List<List<Integer>> list  = new ArrayList<>();
        backtrack(list,new ArrayList<>(),coins,amount,0);

        return list.size();
    }

    private void backtrack(List<List<Integer>> list, ArrayList<Integer> temp, int[] coins, int remain, int start) {
        if(remain < 0) return;
        if(remain == 0){
            list.add(new ArrayList<>(temp));
        } else {
            for(int i = start ; i < coins.length ; i++){
                temp.add(coins[i]);
                backtrack(list,temp,coins,remain-coins[i],i); // the last argument would be i not start
                temp.remove(temp.size()-1);
            }
        }
    }

    /** method 2 dp**/
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
        }
        for(int d:dp){
            System.out.print(d + " ");
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        CoinChangeTwo test = new CoinChangeTwo();
        int[] coins = {3,5,6,7,12,15};
        System.out.println(test.change2(20,coins));
    }
}
