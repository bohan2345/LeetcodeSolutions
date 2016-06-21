package google.twopointer;

import java.util.Arrays;

/**
 * <p>
 * Created by Bohan Zheng on 6/20/2016.
 *
 * @author Bohan Zheng
 */
public class TheSmallestDifference {
    public int smallestDifference(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int a = 0, b = 0;
        int min = Math.abs(A[a] - B[b]);
        while (a < A.length && b <B.length) {
            if (A[a] > B[b]) {
                min = Math.min(A[a] - B[b], min);
                b++;
            } else if (A[a] < B[b]) {
                min = Math.min(B[b] - A[a], min);
                a++;
            } else {
                return 0;
            }
        }
        return min;
    }
}
