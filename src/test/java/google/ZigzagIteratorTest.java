package google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Created by Bohan Zheng on 6/28/2016.
 *
 * @author Bohan Zheng
 */
public class ZigzagIteratorTest {
  @Test
  public void test() {
    List<Integer[]> list = new ArrayList<>();
    list.add(new Integer[]{1, 2});
    list.add(new Integer[]{4, 5, 6, 7});
//        list.add(new Integer[]{8, 9});
    ZigzagIterator<Integer> test = new ZigzagIterator<>(list);
    Integer[] res = {1, 4, 8, 2, 5, 9, 3, 6, 7};
    while (test.hasNext()) {
      System.out.println(test.next());
    }
//        for(int i = 0; i < res.length; i++) {
//            Assert.assertEquals(res[i], test.next());
//        }
  }

  @Test
  public void test2() {
    List<Integer[]> list = new ArrayList<>();
    list.add(new Integer[]{1, 2});
    list.add(new Integer[]{4, 5, 6, 7});
//        list.add(new Integer[]{8, 9});
    ZigzagIterator.ZigzagIteratorII test = new ZigzagIterator.ZigzagIteratorII(Arrays.asList(1, 2), Arrays.asList(4, 5, 6, 7));
    while (test.hasNext()) {
      System.out.println(test.next());
    }
//        for(int i = 0; i < res.length; i++) {
//            Assert.assertEquals(res[i], test.next());
//        }
  }
}
