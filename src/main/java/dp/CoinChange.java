package dp;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * <p>
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * Created by Bohan Zheng on 6/22/2016.
 *
 * @author Bohan Zheng
 */
public class CoinChange {
    /**
     * let f(n) denote the fewest number of coins needed to make up amount n.
     * f(n) = Min(f(n - x)) + 1, x is the coins we have
     */
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        return search(coins, amount, f);
    }

    private int search(int[] coins, int amount, int[] f) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (f[amount] != 0) {
            return f[amount];
        }
        if (f[amount] == -1) {
            return -1;
        }
        int n = Integer.MAX_VALUE;
        for (int x : coins) {
            int tmp = search(coins, amount - x, f);
            tmp = tmp == -1 ? n : tmp;
            n = Math.min(n, tmp);
        }
        if (n == Integer.MAX_VALUE) {
            f[amount] = -1;
            return -1;
        } else {
            f[amount] = n + 1;
            return n + 1;
        }
    }
}
