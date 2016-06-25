package google.dp;

/**
 * There are n coins in a line. (Assume n is even). Two players take turns to take a coin from one
 * of the ends of the line until there are no more coins left. The player with the larger amount of money wins.
 * <p>
 * 1. Would you rather go first or second? Does it matter?
 * 2. Assume that you go first, describe an algorithm to compute the maximum amount of money you can win.
 * <p>
 * Created by Bohan Zheng on 6/22/2016.
 *
 * @author Bohan Zheng
 */
public class CoinsinaLineIII {
    public int maxMoneygoFirst(int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        if (coins.length == 1) {
            return coins[0];
        }
        int n = coins.length;
        int[][] f = new int[n][n];
        int[][] sum = new int[n][n];
        //f[i][j] = sum[i][j] - Math.min(f[i + 1][j], f[i][j - 1]);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    sum[i][j] = coins[j];
                    f[i][j] = coins[j];
                } else {
                    sum[i][j] = coins[j] + sum[i][j - 1];
                    f[i][j] = sum[i][j] - Math.min(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }
}
