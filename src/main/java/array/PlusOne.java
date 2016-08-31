package array;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * <br>
 * Created by Bohan Zheng on 9/2/2015.
 *
 * @author Bohan Zheng
 */
public class PlusOne {
  public int[] plusOne(int[] digits) {
    return plusHelper(digits, digits.length - 1, 1);
  }

  public int[] plusHelper(int[] digits, int i, int num) {
    if (i == -1 && num != 0) {
      int[] newDigits = new int[digits.length + 1];
      newDigits[0] = num;
      System.arraycopy(digits, 0, newDigits, 1, digits.length);
      return newDigits;
    } else if (i == -1) {
      return digits;
    }
    int sum = digits[i] + num;
    digits[i] = sum % 10;
    return plusHelper(digits, i - 1, sum / 10);
  }
}
