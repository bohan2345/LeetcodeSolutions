package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 7/4/16.
 *
 * @author Bohan Zheng
 */
public class FileTransferTotalCostTest {
  @Test
  public void test() {
    FileTransferTotalCost test = new FileTransferTotalCost();
    assertEquals(11, test.totalCost(new int[][]{{1, 2}, {3, 4}}));
  }
}