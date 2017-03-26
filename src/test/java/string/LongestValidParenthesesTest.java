package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 5/24/2016.
 *
 * @author Bohan Zheng
 */
public class LongestValidParenthesesTest {
  @Test
  public void test() {
    LongestValidParentheses test = new LongestValidParentheses();
    assertEquals(4, test.longestValidParentheses("(()()("));
  }

  @Test
  public void test2() {
    LongestValidParentheses test = new LongestValidParentheses();
    assertEquals(4, test.longestValidParentheses("(()))"));
  }

  @Test
  public void test3() {
    LongestValidParentheses test = new LongestValidParentheses();
    assertEquals(2, test.longestValidParentheses("()(()"));
  }
}
