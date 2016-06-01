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
     * 1. If K is greater or equal to n / 2, then we can make one transaction every other day.
     * Then go with the approach in BestTimetoBuyandSellStockII
     * 2. if K is smaller than n / 2:
     * max profit in the first n days with k transaction doesn't have sell on day n: f(n, k)
     * max profit in the first n days with k transaction and must sell on day n: p(n, k)
     * <p>
     * p(n, k) = f(n - 1, k - 1) + prices[n] - prices[n - 1]  # buy stock on day n - 1
     * p(n - 1, k) - prices[n - 1] + prices[n]      # buy stock before day n - 1,
     * p(n - 1, k) is sell the kth stock on day n - 1
     * p(n - 1, k) - prices[n - 1] is buy it back after sell, same as not sell
     * <p>
     * f(n, k) = Max(f(n - 1, k), p(n, k))
     */
    public int maxProfit(int k, int[] prices) {
        if (k == 0) {
            return 0;
        }
        int n = prices.length;
        if (k >= (n / 2)) {
            return quickSolve(prices);
        }
        int[][] mustsell = new int[n + 1][n + 1];   // mustSell[i][j] 表示前i天，至多进行j次交易，第i天必须sell的最大获益
        int[][] globalbest = new int[n + 1][n + 1];  // globalbest[i][j] 表示前i天，至多进行j次交易，第i天可以不sell的最大获益

        mustsell[0][0] = globalbest[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            mustsell[0][i] = globalbest[0][i] = 0;
        }

        for (int i = 1; i < n; i++) {
            int gainorlose = prices[i] - prices[i - 1];
            mustsell[i][0] = 0;
            for (int j = 1; j <= k; j++) {
                mustsell[i][j] = Math.max(globalbest[i - 1][j - 1] + gainorlose, mustsell[i - 1][j] + gainorlose);
                globalbest[i][j] = Math.max(globalbest[i - 1][j], mustsell[i][j]);
            }
        }
        return globalbest[n - 1][k];
    }

    /**
     * f(k, n) max profit on day n with k transaction
     * <p>
     * f(k ,n) = f(k, n - 1)                                            # there is no transaction happen on day n
     * Max(f(k - 1, x) + prices[n] - prices[x]), 0 < x <= n   # there is one transaction on day n (sell)
     * <p>
     * Max(f(k - 1, x) + prices[n] - prices[x]) => Max(f(k - 1, x) - prices[x]) + prices[n]
     * <p>
     * g(k, n) = Max(f(k - 1, x) - prices[x]), 1 <= x <= n              # after k - 1 transaction within n days
     * and one buy action (hold the stock not sell)
     * the max profit I can get.
     * <p>
     * f(k, n) = Max(f(k, n - 1), g(k, n) + prices[n])
     * <p>
     * in implementation, because f(k, ) is only depend on f(k - 1, ) and f(k, )
     * so we can use a one dimensional array and loop k from 1 to k, no need to keep all the value before k - 1 level.
     * g(k, n) is only depends on values in f() from 1 to n on k - 1 level, so we only need to track the max value.
     * ***********************************************************************************
     * Here is another way to understand this approach:
     * let f(i) denotes the max profit you can get on day i,
     * so for one transaction, let's calculate the value for each i = 0 ... n in f(i)
     * let moneyLeft denotes the maximum amount of money left if we buy the stock before day i
     * so f(i) = moneyLeft + prices[i]            # if we sell the stock on day i
     * = f(i - 1)                         # f(i - 1) is the max profit we got the day before,
     * if we can't get a higher profit, we won't sell the stock.
     * after the first transction f(i) denotes the max profit on day i after one transaction.
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
                //moneyLeft means if we buy stock on day i, the max profit
                moneyLeft = Math.max(moneyLeft, f[i] - prices[i]);
                //sell
                f[i] = Math.max(f[i - 1], moneyLeft + prices[i]);
            }
        }
        return f[n - 1];
    }


    public int quickSolve(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }
}