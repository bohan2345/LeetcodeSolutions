package string;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * The number of ways decoding "12" is 2.
 * <p>
 * Created by Bohan Zheng on 4/27/2016.
 *
 * @author Bohan Zheng
 */
public class DecodeWays {
    /**
     * f(i) = f(i - 1) the digit i converted to a letter if s(i) != 0
     *        + f(i - 2) the digit i - 1 and i converted to a letter, if 10 < s(i - 1, i) <= 26
     */
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int f1 = 1, f2 = 1;
        for (int i = 1; i < s.length(); i++) {
            int tmp = 0;
            if (s.charAt(i) != '0') {
                tmp += f2;
            }
            int x = Integer.valueOf(s.substring(i - 1, i + 1));
            if (10 <= x && x <= 26) {
                tmp += f1;
            }
            f1 = f2;
            f2 = tmp;
        }
        return f2;
    }
}
