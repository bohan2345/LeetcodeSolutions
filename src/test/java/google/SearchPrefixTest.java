package google;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * <p>
 * Created by Bohan Zheng on 7/9/16.
 *
 * @author Bohan Zheng
 */
public class SearchPrefixTest {
  @Test
  public void test() {
    SearchPrefix test = new SearchPrefix();
    String[] exptected = {"asdf", "asdg", "asdh"};
    String[] strs = {"asdf", "asdg", "asdh", "asss", "fdsa", "dsfsf"};
    Arrays.sort(strs);
    assertArrayEquals(exptected, test.searchPrefix(strs, "asd"));
  }
}