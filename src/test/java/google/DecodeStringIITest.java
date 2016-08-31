package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 7/9/16.
 *
 * @author Bohan Zheng
 */
public class DecodeStringIITest {
  @Test
  public void test() {
    DecodeStringII test = new DecodeStringII();
    assertEquals("aaamtvxvxvxmtvxvxvxac", test.decode("3a2[mt3[vx]]ac"));
  }

  @Test
  public void test4() {
    DecodeStringII test = new DecodeStringII();
    assertEquals("aaabbbaaabbb", test.decode("2[3a3b]"));
  }

  @Test
  public void test2() {
    DecodeStringII test = new DecodeStringII();
    assertEquals("3a2[mt3[vx]]ac", test.encode("aaamtvxvxvxmtvxvxvxac"));
  }

  @Test
  public void test3() {
    DecodeStringII test = new DecodeStringII();
    assertEquals("2[3a3b]", test.encode("aaabbbaaabbb"));
  }
}