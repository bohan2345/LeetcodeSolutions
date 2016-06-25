package google.dp;

/**
 * Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
 * Notice:
 * You can not divide any item into small pieces.
 * Example
 * If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5],
 * so that the max size we can fill this backpack is 10. If the backpack size is 12.
 * we can select [2, 3, 7] so that we can fulfill the backpack.
 * You function should return the max size we can fill in the given backpack.
 * <p>
 * Created by Bohan Zheng on 6/23/2016.
 *
 * @author Bohan Zheng
 */
public class Backpack {
    /**
     * f(i) denotes the minimum remain spaces in backpack of size i
     * f(i) = MIN(f(i - x)), x ∈ A
     *
     * @param m:
     *         An integer m denotes the size of a backpack
     * @param A:
     *         Given n items with size A[i]
     * @return The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int[] f = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            f[i] = -1;
        }
        search(m, f, A, new boolean[A.length]);
        return m - f[m];
    }

    private void search(int m, int[] f, int[] A, boolean[] used) {
        if (m < 0) {
            return;
        }
        int min = m;
        for (int i = 0; i < A.length; i++) {
            int x = m - A[i];
            if (used[i] || x < 0) {
                continue;
            }
            if (x == 0) {
                min = 0;
                break;
            }
            if (f[x] == -1) {
                used[i] = true;
                search(x, f, A, used);
                used[i] = false;
            }
            min = Math.min(f[x], min);
        }
        f[m] = min;
    }
}
