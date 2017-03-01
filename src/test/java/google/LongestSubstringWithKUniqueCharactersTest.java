package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 5/12/2016.
 *
 * @author Bohan Zheng
 */
public class LongestSubstringWithKUniqueCharactersTest {
  @Test
  public void test() {
    LongestSubstringWithKUniqueCharacters test = new LongestSubstringWithKUniqueCharacters();
    assertEquals("ece", test.longestSubstring("eceab", 2));
  }

  @Test
  public void test2() {
    LongestSubstringWithKUniqueCharacters test = new LongestSubstringWithKUniqueCharacters();
    assertEquals("eceeeee", test.longestSubstring("eceeeeeab", 2));
  }

  @Test
  public void test3() {
    LongestSubstringWithKUniqueCharacters test = new LongestSubstringWithKUniqueCharacters();
    assertEquals("eeeee", test.longestSubstring("eceeeeeab", 1));
  }
}
