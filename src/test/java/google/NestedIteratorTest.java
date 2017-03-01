package google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 7/4/16.
 *
 * @author Bohan Zheng
 */
public class NestedIteratorTest {
  @Test
  public void test() {
    List<NestedIterator.NestedInteger> list = new ArrayList<>();
    List<NestedIterator.NestedInteger> list1 = new ArrayList<>();
    List<NestedIterator.NestedInteger> list2 = new ArrayList<>();
    list1.add(new NestedIterator.NestedInteger(1));
    list1.add(new NestedIterator.NestedInteger(1));
    list2.add(new NestedIterator.NestedInteger(1));
    list2.add(new NestedIterator.NestedInteger(1));
    list.add(new NestedIterator.NestedInteger(list1));
    list.add(new NestedIterator.NestedInteger(2));
    list.add(new NestedIterator.NestedInteger(list2));
    NestedIterator nestedIterator = new NestedIterator(list);
    assertEquals(1, (int) nestedIterator.next());
    assertEquals(1, (int) nestedIterator.next());
    assertEquals(2, (int) nestedIterator.next());
    assertEquals(1, (int) nestedIterator.next());
    assertEquals(1, (int) nestedIterator.next());
  }
}