package LeetCode;

import java.util.Arrays;

public class ChangeCoins {
    public int coinChange(int[] coins, int amount) {
        // dp[i] will store the minimum number of coins required for amount i
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Fill dp with a value larger than the amount
        dp[0] = 0; // Base case: to make amount 0, we need 0 coins

        // Process each amount from 1 to the target amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still amount + 1, it means the amount can't be formed
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        ChangeCoins c = new ChangeCoins();
        int[] coins = new int[]{186,419,83,408};
        System.out.println(c.coinChange(coins,6249));
    }
}
