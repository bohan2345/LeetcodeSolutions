package string;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * <p>
 * Note:
 * -The numbers can be arbitrarily large and are non-negative.
 * -Converting the input string to integer is NOT allowed.
 * -You should NOT use internal library such as BigInteger.
 * <p>
 * Created by Bohan Zheng on 5/5/2016.
 *
 * @author Bohan Zheng
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] d = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int a = num1.length() - 1 - i;
                int b = num2.length() - 1 - j;
                d[a + b] += Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
            }
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < d.length; i++) {
            int n = d[i] + carry;
            int mod = n % 10;
            carry = n / 10;
            sb.insert(0, mod);
        }
        while (sb.charAt(0) == '0' && sb.length() != 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
