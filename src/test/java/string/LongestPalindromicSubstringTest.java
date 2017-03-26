package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 4/18/2016.
 *
 * @author Bohan Zheng
 */
public class LongestPalindromicSubstringTest {
  @Test
  public void test() {
    LongestPalindromicSubstring test = new LongestPalindromicSubstring();
    assertEquals("aba", test.longestPalindrome("caba"));
  }

  @Test
  public void test2() {
    LongestPalindromicSubstring test = new LongestPalindromicSubstring();
    assertEquals("", test.longestPalindrome(""));
  }
}
