package google;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 7/5/2016.
 *
 * @author Bohan Zheng
 */
public class CaesarCipherTest {
  @Test
  public void test() {
    CaesarCipher test = new CaesarCipher();
    Assert.assertEquals("bcdefghijklmnopqrstuvwxyza", test.encript("abcdefghijklmnopqrstuvwxyz", 1));
  }

  @Test
  public void test2() {
    CaesarCipher test = new CaesarCipher();
    Assert.assertEquals("zabcdefghijklmnopqrstuvwxy", test.encript("abcdefghijklmnopqrstuvwxyz", -1));
  }

  @Test
  public void test3() {
    CaesarCipher test = new CaesarCipher();
    Assert.assertEquals("bcdefghijklmnopqrstuvwxyza", test.encript("abcdefghijklmnopqrstuvwxyz", 27));
  }

  @Test
  public void test4() {
    CaesarCipher test = new CaesarCipher();
    Assert.assertEquals("zabcdefghijklmnopqrstuvwxy", test.encript("abcdefghijklmnopqrstuvwxyz", -27));
  }
}
