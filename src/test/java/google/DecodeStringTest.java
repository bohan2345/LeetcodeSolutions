package google;

import org.junit.Assert;
import org.junit.Test;

/**
 * 输入 a[4]bcd[3]efg, 要返回 aaaabcdddefg.
 * <p>
 * Created by Bohan Zheng on 7/4/16.
 *
 * @author Bohan Zheng
 */
public class DecodeStringTest {
  @Test
  public void test() {
    DecodeString test = new DecodeString();
    Assert.assertEquals("aaaabcdddefg", test.decode("a[4]bcd[3]efg"));
  }

  @Test
  public void test2() {
    DecodeString test = new DecodeString();
    Assert.assertEquals("a[4]bcd[3]efg", test.encode("aaaabcdddefg"));
  }
}
