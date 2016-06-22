package dp;

/**
 * There are n coins with different value in a line. Two players take turns to take one
 * or two coins from left side until there are no more coins left. The player who take
 * the coins with the most value wins.
 * <p>
 * Could you please decide the first player will win or lose?
 * <p>
 * Created by Bohan Zheng on 6/22/2016.
 *
 * @author Bohan Zheng
 */
public class CoinsinaLineII {
    /**
     * let f(i) denote the max money when there are i coins left and its your turn.
     * if you take 1 coin, then it's your opponent's turn, the max max money he can get is f(i - 1);
     * if you take 2 coins, the max money your opponenet can get is f(i - 2)
     * so f(i) = TOTAL_SUM(i) - MIN(f(i - 1), f(i - 2))
     *
     * @param values:
     *         an array of integers
     * @return a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        if (values == null || values.length == 0) {
            return false;
        }
        if (values.length < 3) {
            return true;
        }
        int n = values.length;
        int[] totalSum = new int[n];
        totalSum[n - 1] = values[n - 1];
        for (int i = 2; i <= n; i++) {
            totalSum[n - i] = totalSum[n - i + 1] + values[n - i];
        }
        int a = values[n - 1];
        int b = values[n - 1] + values[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            int c = totalSum[i] - Math.min(a, b);
            a = b;
            b = c;
        }
        return b > totalSum[0] - b;
    }
}
