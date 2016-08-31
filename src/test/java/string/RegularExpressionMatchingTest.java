package string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 5/23/2016.
 *
 * @author Bohan Zheng
 */
public class RegularExpressionMatchingTest {
  @Test
  public void test() {
    RegularExpressionMatching test = new RegularExpressionMatching();
    assertFalse(test.isMatch("aa", "a"));
  }

  @Test
  public void test2() {
    RegularExpressionMatching test = new RegularExpressionMatching();
    assertTrue(test.isMatch("aa", "aa"));
  }

  @Test
  public void test3() {
    RegularExpressionMatching test = new RegularExpressionMatching();
    assertFalse(test.isMatch("abb", "b*"));
  }

  @Test
  public void test4() {
    RegularExpressionMatching test = new RegularExpressionMatching();
    assertTrue(test.isMatch("aaa", "a*"));
  }

  @Test
  public void test5() {
    RegularExpressionMatching test = new RegularExpressionMatching();
    assertTrue(test.isMatch("aaa", ".*"));
  }

  @Test
  public void test6() {
    RegularExpressionMatching test = new RegularExpressionMatching();
    assertTrue(test.isMatch("aab", "a*a*b*"));
  }

  @Test
  public void test7() {
    RegularExpressionMatching test = new RegularExpressionMatching();
    assertTrue(test.isMatch("aab", ".*"));
  }

  @Test
  public void test8() {
    RegularExpressionMatching test = new RegularExpressionMatching();
    assertFalse(test.isMatch("aab", ""));
  }

  @Test
  public void test9() {
    RegularExpressionMatching test = new RegularExpressionMatching();
    assertTrue(test.isMatch("", "a*"));
  }

  @Test
  public void test10() {
    RegularExpressionMatching test = new RegularExpressionMatching();
    assertTrue(test.isMatch("a", "ab*"));
  }
}
