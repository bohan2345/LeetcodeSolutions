package math;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * For example,
 * <p>
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * <p>
 * Created by Bohan Zheng on 5/12/2016.
 *
 * @author Bohan Zheng
 */
public class FractiontoRecurringDecimal {
  public String fractionToDecimal(int numerator, int denominator) {
    int num = numerator / denominator;
    numerator = numerator % denominator;
    String frac = fractionHelper(numerator, denominator, new StringBuilder(), new HashSet<>());
    return frac.equals("0") ? Integer.toString(num) : Integer.toString(num) + "." + frac;
  }

  private String fractionHelper(int numerator, int denominator, StringBuilder sb, Set<Integer> set) {
    numerator *= 10;
    int num = numerator / denominator;
    numerator = numerator % denominator;
    if (numerator == 0) {
      sb.append(num);
      return sb.toString();
    } else {
      if (set.contains(numerator)) {
        return sb.insert(0, '(').append(')').toString();
      } else {
        sb.append(num);
        set.add(numerator);
        return fractionHelper(numerator, denominator, sb, set);
      }
    }
  }
}
