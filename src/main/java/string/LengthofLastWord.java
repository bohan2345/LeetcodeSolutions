package string;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Created by Bohan Zheng on 4/26/2016.
 *
 * @author Bohan Zheng
 */
public class LengthofLastWord {
  public int lengthOfLastWord(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int i = s.length() - 1;
    while (i >= 0 && s.charAt(i) == ' ') {
      i--;
    }
    int leng = 0;
    while (i >= 0 && s.charAt(i) != ' ') {
      leng++;
      i--;
    }
    return leng;
  }
}
