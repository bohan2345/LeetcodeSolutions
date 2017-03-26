package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 3/11/16.
 *
 * @author Bohan Zheng
 */
public class LongestCommonPrefixTest {
  @Test
  public void test() {
    LongestCommonPrefix test = new LongestCommonPrefix();
    assertEquals("as", test.longestCommonPrefix(new String[]{"asd", "asf"}));
  }

  @Test
  public void test2() {
    LongestCommonPrefix test = new LongestCommonPrefix();
    assertEquals("asd", test.longestCommonPrefix(new String[]{"asd", "asd"}));
  }

  @Test
  public void test3() {
    LongestCommonPrefix test = new LongestCommonPrefix();
    assertEquals("as", test.longestCommonPrefix(new String[]{"asd", "as"}));
  }
}