package google;

/**
 * <p>
 * Created by Bohan Zheng on 7/6/16.
 *
 * @author Bohan Zheng
 */
public class GeometricPcrogression {
    public long sum(long n, int p) {
        if (p == 0) {
            return 1;
        }
        if (p == 1) {
            return n + 1;
        }
        if (p % 2 == 0) {
            long temp = sum(n * n, (p - 2) / 2);
            return 1 + temp * (n + n * n);
        } else {
            long temp = sum(n * n, (p - 1) / 2);
            return temp * (1 + n);
        }
    }

    public long sumII(int n, int p) {
        long x = 1;
        long sum = 1;
        for (int i = 1; i <= p; i++) {
            x *= n;
            sum += x;
        }
        return sum;
    }
}
