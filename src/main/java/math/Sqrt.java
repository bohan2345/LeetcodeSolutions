package math;

/**
 * <p>
 * Created by Bohan Zheng on 2/17/2016.
 *
 * @author Bohan Zheng
 */
public class Sqrt {
  public int mySqrt(int x) {
    if (x == 1) {
      return 1;
    }
    double sqrt = x / 2.0;
    while (sqrt != 0 && Math.abs(sqrt - x / sqrt) > 0.000000001) {
      sqrt = (sqrt + x / sqrt) / 2.0;
    }
    // just for passing leetcode test case!!!
    return (int) Math.floor(sqrt);
  }
}
