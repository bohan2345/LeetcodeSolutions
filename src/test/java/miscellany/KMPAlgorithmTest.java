package miscellany;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 3/22/2016.
 *
 * @author Bohan Zheng
 */
public class KMPAlgorithmTest {
  @Test
  public void test() {
    KMPAlgorithm test = new KMPAlgorithm();
    String pattern = "ABCDABD";
//        System.out.println(pattern.substring(2,5));
    assertEquals(15, test.findMatch("ABC ABCDAB ABCDABCDABDE", pattern));
  }

  @Test
  public void test2() {
    KMPAlgorithm test = new KMPAlgorithm();
    String pattern = "a";
    assertEquals(0, test.findMatch("a", pattern));
  }

  @Test
  public void test3() {
    KMPAlgorithm test = new KMPAlgorithm();
    String pattern = "aacecaaa";
    test.KMPTable(pattern.toCharArray());
  }

  @Test
  public void test4() {
    KMPAlgorithm test = new KMPAlgorithm();
    String pattern = "mtvmtvmt";
    int[] t = test.KMPTable(pattern.toCharArray());
    assertTrue(true);
  }
}
