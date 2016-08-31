package string;

/**
 * Validate if a given string is numeric.
 * <p>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 * <p>
 * Created by Bohan Zheng on 4/14/2016.
 *
 * @author Bohan Zheng
 */
public class ValidNumber {
  public boolean isNumber(String s) {
    int eSignPos = -1; // e sign position, default to -1 e sign not find
    int eSignCount = 0; // number of e sign found
    int dSignPos = -1; // decimal mark position
    int dSignCount = 0;
    int nCount = 0; // number of valid digit
    s = s.trim();
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (c <= '9' && c >= '0') {
        nCount++;
      } else if (c == 'e') {
        eSignPos = i;
        eSignCount++;
        if (eSignCount > 1)
          return false;
      } else if (c == '.') {
        dSignPos = i;
        dSignCount++;
        if (dSignCount > 1)
          return false;
      } else if (c == '+' || c == '-') {
        if (i != eSignPos + 1)
          return false;
      } else {
        return false;
      }
    }
    if (nCount == 0) return false;
    else if (eSignCount == 0) return true;
    else if (eSignPos < dSignPos) return false;
    else return isNumber(s.substring(0, eSignPos)) && isNumber(s.substring(eSignPos + 1));
  }
}
