package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 7/10/16.
 *
 * @author Bohan Zheng
 */
public class LargestMultipleStringsWithDistinctCharactorTest {
  @Test
  public void test() {
    String[] strs = {"asdfasd", "ghjk", "zxcvzxcv", "zxcvzxcc", "x"};
    LargestMultipleStringsWithDistinctCharactor test = new LargestMultipleStringsWithDistinctCharactor();
    assertEquals(56, test.max(strs));
  }
}