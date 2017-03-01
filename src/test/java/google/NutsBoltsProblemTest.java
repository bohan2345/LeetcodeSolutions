package google;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 6/14/2016.
 *
 * @author Bohan Zheng
 */
public class NutsBoltsProblemTest {
  @Test
  public void test() {
    NutsBoltsProblem test = new NutsBoltsProblem();
    String[] nuts = {"a", "c", "b", "d"};
    String[] bolts = {"c", "d", "a", "b"};
    test.sortNutsAndBolts(nuts, bolts, String::compareTo);
    Assert.assertArrayEquals(nuts, bolts);
  }
}
