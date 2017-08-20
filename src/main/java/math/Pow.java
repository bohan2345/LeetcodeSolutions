package math;

/**
 * <p>
 * Created by Bohan Zheng on 2/17/2016.
 *
 * @author Bohan Zheng
 */
public class Pow {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        double temp = myPow(x, n / 2);
        if (n % 2 == 0)
            return temp * temp;
        else if (n > 0 && n % 2 != 0) {
            return temp * temp * x;
        } else if (n < 0 && n % 2 != 0) {
            return temp * temp / x;
        } else
            return 0;
    }
}
