package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 6/6/2016.
 *
 * @author Bohan Zheng
 */
public class BinaryMinHeapTest {
  @Test
  public void test() {
    int[] nums = {5, 4, 3, 2, 1};
    BinaryMinHeap heap = new BinaryMinHeap(nums);
    assertEquals(1, heap.extract());
    assertEquals(2, heap.extract());
    assertEquals(3, heap.extract());
    assertEquals(4, heap.extract());
    assertEquals(5, heap.extract());
  }
}
