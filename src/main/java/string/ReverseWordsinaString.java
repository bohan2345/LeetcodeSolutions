package string;

/**
 * Given an input string, reverse the string word by word.
 * <p>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * <p>
 * Created by Bohan Zheng on 3/29/2016.
 *
 * @author Bohan Zheng
 */
public class ReverseWordsinaString {
  public String reverseWords(String s) {
    s = s.trim();
    StringBuilder sb = new StringBuilder();
    int j = s.length();
    for (int i = s.length() - 1; i >= 0; --i) {
      if (s.charAt(i) == ' ') {
        if (i + 1 != j)
          sb.append(s.substring(i + 1, j)).append(' ');
        j = i;
      } else if (i == 0) {
        sb.append(s.substring(i, j));
      }
    }
    return sb.toString();
  }
}
