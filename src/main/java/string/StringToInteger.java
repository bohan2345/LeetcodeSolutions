package string;

/**
 * Implement atoi to convert a string to an integer.
 * <p>
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this character,
 * takes an optional initial plus or minus sign followed by as many numerical digits
 * as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace
 * characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned. If the correct
 * value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * <p>
 * Created by Bohan Zheng on 4/4/2016.
 *
 * @author Bohan Zheng
 */
public class StringToInteger {
  public int myAtoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    int i = 0;
    while (i < str.length()) {
      if (str.charAt(i) == ' ') {
        i++;
      } else {
        break;
      }
    }
    int j = i;
    if (str.charAt(j) == '-' || str.charAt(j) == '+') {
      j++;
    }
    while (j < str.length()) {
      if (str.charAt(j) >= '0' && str.charAt(j) <= '9') {
        j++;
      } else {
        break;
      }
    }
    str = str.substring(i, j);
    if (str.length() == 0 || str.equals("+") || str.equals("-")) {
      return 0;
    }
    try {
      return Integer.parseInt(str);
    } catch (NumberFormatException e) {
      return str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }
  }
}
