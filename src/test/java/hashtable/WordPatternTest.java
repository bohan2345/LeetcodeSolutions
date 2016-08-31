package hashtable;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 3/6/16.
 *
 * @author Bohan Zheng
 */
public class WordPatternTest {

  @Test
  public void test() {
    WordPattern test = new WordPattern();
    Assert.assertTrue(test.wordPattern("abba", "dog cat cat dog"));
  }

  @Test
  public void test2() {
    WordPattern test = new WordPattern();
    Assert.assertFalse(test.wordPattern("aaaa", "dog cat cat dog"));
  }

  @Test
  public void test3() {
    WordPattern test = new WordPattern();
    Assert.assertFalse(test.wordPattern("abba", "dog cat cat fish"));
  }

  @Test
  public void test4() {
    WordPattern test = new WordPattern();
    Assert.assertFalse(test.wordPattern("abba", "dog dog dog dog"));
  }
}
