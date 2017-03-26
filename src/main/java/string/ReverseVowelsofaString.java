package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * <p>
 * Created by Bohan Zheng on 4/25/2016.
 *
 * @author Bohan Zheng
 */
public class ReverseVowelsofaString {
  public String reverseVowels(String s) {
    char[] chars = s.toCharArray();
    int i = 0, j = s.length() - 1;
    Set<Character> vowel = new HashSet<>(10);
    vowel.addAll(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
    while (i < j) {
      while (i < chars.length && !vowel.contains(chars[i])) {
        i++;
      }
      while (j >= 0 && !vowel.contains(chars[j])) {
        j--;
      }
      if (i < chars.length && j >= 0 && i < j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        i++;
        j--;
      }
    }
    return new String(chars);
  }
}
