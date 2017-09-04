package array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * <p>
 * Created by Bohan Zheng on 2/17/2016.
 *
 * @author Bohan Zheng
 */
public class BestTimetoBuyandSellStockIV {
    /**
     * The basic idea is to create two tables. hold and unhold.
     * <p>
     * hold[i][j] means the maximum profit with at most j transaction from 0 to i-th day.
     * hold means you have a stock in your hand.
     * unhold[i][j] means the maximum profit with at most j transaction from 0 to i-th day.
     * unhold means you don't have a stock in your hand.
     * <p>
     * The equation is
     * hold[i][j] = Math.max(unhold[i-1][j] - prices[i], hold[i-1][j]);
     * unhold[i][j] = Math.max(hold[i-1][j-1] + prices[i], unhold[i-1][j]);
     * <p>
     * when you sell your stock this is a transaction but when you buy a stock, it is not considered as a full
     * transaction. so this is why the two equation look a little different.
     * And we have to initiate hold table when k = 0.
     * When the situation is you can not buy a new stock at the same day when you sell it. For example you can only buy
     * a new stock after one day you sell it. The same idea. Another situation is when you have to pay a transaction fee
     * for each transaction, just make a modification when you sell it, So just change the unhold equation a little.
     */
    public int maxProfit(int k, int[] prices) {
        if (k > prices.length / 2)
            return quickSolve(prices);
        int[][] hold = new int[prices.length][k + 1];
        int[][] unhold = new int[prices.length][k + 1];
        hold[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++)
            hold[i][0] = Math.max(hold[i - 1][0], -prices[i]);

        for (int j = 1; j <= k; j++)
            hold[0][j] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                hold[i][j] = Math.max(unhold[i - 1][j] - prices[i], hold[i - 1][j]);
                unhold[i][j] = Math.max(hold[i - 1][j - 1] + prices[i], unhold[i - 1][j]);
            }
        }
        return unhold[prices.length - 1][k];
    }

    /**
     * f(k, n) max profit on day n with k transaction
     * <p>
     * f(k ,n) = f(k, n - 1)                                            # there is no transaction happen on day n
     * .         Max(f(k - 1, x) + prices[n] - prices[x]), 0 < x <= n   # there is one transaction on day n (sell)
     * <p>
     * .         Max(f(k - 1, x) + prices[n] - prices[x]) => Max(f(k - 1, x) - prices[x]) + prices[n]
     * <p>
     * g(k, n) = Max(f(k - 1, x) - prices[x]), 1 <= x <= n              # after k - 1 transaction within n days
     * and one buy action (hold the stock not sell) the max profit I can get.
     * <p>
     * f(k, n) = Max(f(k, n - 1), g(k, n) + prices[n])
     * <p>
     * in implementation, because f(k, ) is only depend on f(k - 1, ) and f(k, )
     * so we can use a one dimensional array and loop k from 1 to k, no need to keep all the value before k - 1 level.
     * g(k, n) is only depends on values in f() from 1 to n on k - 1 level, so we only need to track the max value.
     * ###############################################################################################################
     * Here is another way to understand this approach:
     * let f(i) denotes the max profit you can get on day i,
     * so for one transaction, let's calculate the value for each i = 0 ... n in f(i)
     * let moneyLeft denotes the maximum amount of money left if we buy the stock before day i
     * so f(i) = moneyLeft + prices[i]            # if we sell the stock on day i
     * = f(i - 1)                         # f(i - 1) is the max profit we got the day before,
     * if we can't get a higher profit, we won't sell the stock.
     * after the first transaction f(i) denotes the max profit on day i after one transaction.
     * we can base on these values calculate the max profit for the second transaction, for each i = 0 ... n
     * init step is to let moneyLeft = f(0) - prices[0]   # if we buy stock on day 0, how much money we left
     */
    public int maxProfit2(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        if (k > (n / 2)) return quickSolve(prices);
        int[] f = new int[n];
        for (int j = 1; j <= k; j++) {
            int moneyLeft = f[0] - prices[0];
            for (int i = 1; i < n; i++) {
                // moneyLeft means if we buy stock on day i, the max profit
                moneyLeft = Math.max(moneyLeft, f[i] - prices[i]);
                // sell
                f[i] = Math.max(f[i - 1], moneyLeft + prices[i]);
            }
        }
        return f[n - 1];
    }

    /**
     * dp[i, j] represents the max profit up until prices[j] using at most i transactions.
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[k] + dp[i-1, k]) { jj in range of [0, j-1] }
     * .        = max(dp[i, j-1], prices[j] + max(dp[i-1, k] - prices[k]))
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
     */
    public int maxProfit3(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;
        // if k >= n/2, then you can make maximum number of transactions.
        if (k > (n / 2)) return quickSolve(prices);
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }


    private int quickSolve(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }
}