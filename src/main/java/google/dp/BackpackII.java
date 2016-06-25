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
     * f(i) denotes the maximum value with a backpack of size i
     * f(i) = MAX(f(i - x) + V[x]), x ∈ A
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int[] f = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            f[i] = -1;
        }
        boolean[] used = new boolean[A.length];
        search(m, A, V, f, used);
        return f[m];
    }

    private void search(int m, int[] A, int[] V, int[] f, boolean[] used) {
        if (m < 0) {
            return;
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            int x = m - A[i];
            if (used[i] || x <= 0) {
                continue;
            }
            if (f[x] == -1) {
                used[i] = true;
                search(m - A[i], A, V, f, used);
                used[i] = false;
            }
            max = Math.max(max, f[x] + V[i]);
        }
        System.out.println(m + " : " + max);
        f[m] = max;
    }
}
