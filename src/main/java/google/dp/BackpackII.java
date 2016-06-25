package google.dp;

/**
 * Given n items with size Ai and value Vi, and a backpack with size m.
 * What's the maximum value can you put into the backpack?
 * Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4],
 * and a backpack with size 10. The maximum value is 9.
 * <p>
 * Created by Bohan Zheng on 6/23/2016.
 *
 * @author Bohan Zheng
 */
public class BackpackII {
    /**
     * f(i, j) denotes the maximum value with a backpack of size j and first i items
     * f(i) = MAX(f(i - 1, j),                  // not use the ith item
     *            f(i - 1, j - A[i]) + V[i])    // use the ith item
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int[][] f = new int[A.length + 1][m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j - A[i - 1] >= 0) {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return f[A.length][m];
    }
}
