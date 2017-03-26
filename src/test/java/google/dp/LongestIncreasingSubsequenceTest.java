package google.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 6/21/2016.
 *
 * @author Bohan Zheng
 */
public class LongestIncreasingSubsequenceTest {
  @Test
  public void test() {
    int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    assertEquals(4, new LongestIncreasingSubsequence().lengthOfLISII(nums));
  }

  @Test
  public void test2() {
    int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
    assertEquals(6, new LongestIncreasingSubsequence().lengthOfLIS(nums));
  }
}
