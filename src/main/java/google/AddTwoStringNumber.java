package google;

/**
 * <p>
 * Created by Bohan Zheng on 6/30/2016.
 *
 * @author Bohan Zheng
 */
public class AddTwoStringNumber {
    public String add(String num1, String num2) {
        if (num1.charAt(0) == '-' && num2.charAt(0) != '-') {
            num1 = num1.substring(1);
            return num1.compareTo(num2) > 0 ?
                    "-" + subtractHelper(num1, num1.length() - 1, num2, num2.length() - 1, new StringBuilder(), 0) :
                    subtractHelper(num2, num2.length() - 1, num1, num1.length() - 1, new StringBuilder(), 0);
        }
        if (num2.charAt(0) == '-' && num1.charAt(0) != '-') {
            num2 = num2.substring(1);
            return num1.compareTo(num2) > 0 ?
                    subtractHelper(num1, num1.length() - 1, num2, num2.length() - 1, new StringBuilder(), 0) :
                    "-" + subtractHelper(num2, num2.length() - 1, num1, num1.length() - 1, new StringBuilder(), 0);
        }
        String negetive = "";
        if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
            num1 = num1.substring(1);
            num2 = num2.substring(1);
            negetive = "-";
        }
        return negetive + addHelper(num1, num1.length() - 1, num2, num2.length() - 1, new StringBuilder(), 0);
    }

    private String addHelper(String num1, int i, String num2, int j, StringBuilder sb, int carry) {
        if (i < 0 && j < 0) {
            if (carry != 0) {
                sb.insert(0, carry);
            }
            return sb.toString();
        }
        int num = carry;
        if (i >= 0) {
            num += Character.getNumericValue(num1.charAt(i));
        }
        if (j >= 0) {
            num += Character.getNumericValue(num2.charAt(j));
        }
        carry = num / 10;
        sb.insert(0, num % 10);
        return addHelper(num1, i - 1, num2, j - 1, sb, carry);
    }

    /**
     * @return num1 - num2
     */
    private String subtractHelper(String num1, int i, String num2, int j, StringBuilder sb, int carry) {
        if (i < 0 && j < 0) {
            for (int k = 0; k < sb.length() - 1; k++) {
                if (sb.charAt(k) == '0') {
                    sb.deleteCharAt(k);
                }
            }
            return sb.toString();
        }
        int num = Character.getNumericValue(num1.charAt(i)) - carry;
        if (j >= 0) {
            num -= Character.getNumericValue(num2.charAt(j));
        }
        if (num < 0) {
            carry = 1;
            num = num * -1;
        } else {
            carry = 0;
        }
        sb.insert(0, num);
        return subtractHelper(num1, i - 1, num2, j - 1, sb, carry);
    }
}
