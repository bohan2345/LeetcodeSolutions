package string;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 3/11/16.
 *
 * @author Bohan Zheng
 */
public class ValidPalindromeTest {
  @Test
  public void test() {
    ValidPalindrome test = new ValidPalindrome();
    assertTrue(test.isPalindrome("A man, a plan, a canal: Panama"));
  }

  @Test
  public void test2() {
    ValidPalindrome test = new ValidPalindrome();
    assertTrue(test.isPalindrome("...A man, a plan, a canal: Panama"));
  }

  @Test
  public void test3() {
    ValidPalindrome test = new ValidPalindrome();
    assertTrue(test.isPalindrome("."));
  }

  @Test
  public void test4() {
    ValidPalindrome test = new ValidPalindrome();
    assertTrue(test.isPalindrome("aaa"));
  }
}