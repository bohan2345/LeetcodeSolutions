package google;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 6/15/2016.
 *
 * @author Bohan Zheng
 */
public class PartitionArrayByOddEvenTest {
  @Test
  public void test() {
    PartitionArrayByOddEven test = new PartitionArrayByOddEven();
    int[] arrays = {1, 2, 3, 4, 5, 6};
    test.partition(arrays);
    assertTrue(arrays[0] % 2 == 0);
    assertTrue(arrays[1] % 2 == 0);
    assertTrue(arrays[2] % 2 == 0);
  }

  @Test
  public void test2() {
    PartitionArrayByOddEven test = new PartitionArrayByOddEven();
    int[] arrays = {1, 2, 3, 4, 5};
    test.partition(arrays);
    assertTrue(arrays[0] % 2 == 0);
    assertTrue(arrays[1] % 2 == 0);
    assertTrue(arrays[2] % 2 == 1);
  }

  @Test
  public void test3() {
    PartitionArrayByOddEven test = new PartitionArrayByOddEven();
    int[] arrays = {};
    test.partition(arrays);
  }
}
