package string;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * <p>
 * Created by Bohan Zheng on 4/25/2016.
 *
 * @author Bohan Zheng
 */
public class AddBinary {
  public String addBinary(String a, String b) {
    return addBinary(a, b, a.length() - 1, b.length() - 1, 0, new StringBuilder());
  }

  private String addBinary(String a, String b, int i, int j, int carry, StringBuilder sb) {
    if (i < 0 && j < 0) {
      if (carry == 0) {
        return sb.toString();
      } else {
        return sb.insert(0, carry).toString();
      }
    }
    int numa = i >= 0 ? Character.getNumericValue(a.charAt(i)) : 0;
    int numb = j >= 0 ? Character.getNumericValue(b.charAt(j)) : 0;
    int n = numa + numb + carry;
    carry = n / 2;
    n -= 2 * carry;
    sb.insert(0, n);
    return addBinary(a, b, i - 1, j - 1, carry, sb);
  }
}