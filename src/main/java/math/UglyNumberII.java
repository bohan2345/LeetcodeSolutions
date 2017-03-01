package math;

/**
 * <p>
 * Created by Bohan Zheng on 10/23/16.
 *
 * @author Bohan Zheng
 */
public class UglyNumberII {
  public int nthUglyNumber(int n) {
    if (n < 1) {
      throw new RuntimeException("Invalid argument");
    }
    int[] uglyNums = new int[n];
    uglyNums[0] = 1;
    int i = 0, j = 0, k = 0;
    for (int x = 1; x < n; x++) {
      int m2 = uglyNums[i] * 2;
      int m3 = uglyNums[j] * 3;
      int m5 = uglyNums[k] * 5;
      if (m2 <= m3 && m2 <= m5) {
        i++;
        uglyNums[x] = m2;
      }
      if (m3 <= m2 && m3 <= m5) {
        j++;
        uglyNums[x] = m3;
      }
      if (m5 <= m2 && m5 <= m3) {
        k++;
        uglyNums[x] = m5;
      }
    }
    return uglyNums[n - 1];
  }
}
