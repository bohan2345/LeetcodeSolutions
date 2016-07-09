package google;

/**
 * <p>
 * Created by Bohan Zheng on 7/8/16.
 *
 * @author Bohan Zheng
 */
public class BinaryWithNumberTwo {
    /**
     * f(i, n) denotes using i digits total representation of number n
     * f(i, n) = f(i - 1, n) + ,             digits[i] = 0
     * #         f(i - 1, n - 2 ^ i) + ,     digits[i] = 1 && n - 2 ^ i >= 0
     * #         f(i - 1, n - 2 * 2 ^ i),    digits[i] = 2 && n - 2 * 2 ^ i >= 0
     */
    public int totalNumber(int n) {
        // log (base 2) (n) = log(n) / log(2)
        int[][] f = new int[(int) (Math.log(n) / Math.log(2)) + 2][n + 1];

        int p = 1;
        f[0][0] = 1;
        for (int i = 1; i < f.length; i++) {
            for (int j = 0; j <= n; j++) {
                f[i][j] = f[i - 1][j];

                if (j - p >= 0) {
                    f[i][j] += f[i - 1][j - p];
                }
                if (j - 2 * p >= 0) {
                    f[i][j] += f[i - 1][j - 2 * p];
                }
            }
            p *= 2;
        }

        return f[f.length - 1][n];
    }
}
