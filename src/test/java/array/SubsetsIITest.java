package array;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 10/7/2015.
 *
 * @author Bohan Zheng
 */
public class SubsetsIITest {
  SubsetsII test = new SubsetsII();

  @Test
  public void test() {
    List<List<Integer>> actual = test.subsetsWithDup(new int[]{1, 2, 2});
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList());
    expected.add(Arrays.asList(1));
    expected.add(Arrays.asList(2));
    expected.add(Arrays.asList(1, 2));
    expected.add(Arrays.asList(2, 2));
    expected.add(Arrays.asList(1, 2, 2));
    assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
  }
}
