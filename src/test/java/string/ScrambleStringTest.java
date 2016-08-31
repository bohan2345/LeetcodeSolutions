package string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 4/13/2016.
 *
 * @author Bohan Zheng
 */
public class ScrambleStringTest {
  @Test
  public void test() {
    ScrambleString test = new ScrambleString();
    assertTrue(test.isScramble("great", "rgeat"));
  }

  @Test
  public void test2() {
    ScrambleString test = new ScrambleString();
    assertTrue(test.isScramble("great", "rgtae"));
  }

  @Test
  public void test3() {
    ScrambleString test = new ScrambleString();
    assertFalse(test.isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
  }
}
