package main.array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * <p>
 * Created by Bohan Zheng on 12/15/2015.
 *
 * @author Bohan Zheng
 */
public class BestTimetoBuyandSellStock {
    /**
     * max profit on day n = f(n) = max(f(n - 1), prices[n] - minPrice(n - 1))
     * min price on day n = minPrice(n) = min(prices[n], minPrice(n - 1))
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
