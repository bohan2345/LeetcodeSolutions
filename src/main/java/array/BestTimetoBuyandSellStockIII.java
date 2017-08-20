package array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p>
 * Created by Bohan Zheng on 12/15/2015.
 *
 * @author Bohan Zheng
 */
public class BestTimetoBuyandSellStockIII {
    /**
     * f(a, b): max profit from day a to day b, with only one transaction
     * maxprofit(0, n) = Max(f(0, i) + f(i, n)) 0 < i < n
     * f(0, i) = Max(p(i) - minPrice(i - 1), f(0, i - 1))
     * f(i, n) = Max(maxPrice(i + 1) - p(i), f(i + 1, n))
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxPrice = prices[prices.length - 1]; // max price from i to n
        int minPrice = prices[0]; // min price from 0 to i
        int[] max1 = new int[prices.length], max2 = new int[prices.length];
        for (int j = 1; j < prices.length; j++) {
            max1[j] = Math.max(prices[j] - minPrice, max1[j - 1]);
            minPrice = Math.min(minPrice, prices[j]);
        }
        for (int j = prices.length - 2; j >= 0; j--) {
            max2[j] = Math.max(maxPrice - prices[j], max2[j + 1]);
            maxPrice = Math.max(maxPrice, prices[j]);
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            max = Math.max(max, max1[i] + max2[i]);
        }
        return max;
    }
}
