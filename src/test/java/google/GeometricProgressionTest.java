package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 7/6/16.
 *
 * @author Bohan Zheng
 */
public class GeometricProgressionTest {
  @Test
  public void test() {
    GeometricProgression test = new GeometricProgression();
    assertEquals(9223372036854775807L, test.sumII(2, 62));
  }

  @Test
  public void test2() {
    GeometricProgression test = new GeometricProgression();
    assertEquals(9223372036854775807L, test.sum(2, 62));
  }
}