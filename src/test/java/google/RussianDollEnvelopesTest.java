package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 7/5/2016.
 *
 * @author Bohan Zheng
 */
public class RussianDollEnvelopesTest {
  @Test
  public void test() {
    //[[5,4],[6,4],[6,7],[2,3]]
    RussianDollEnvelopes test = new RussianDollEnvelopes();
    int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
    assertEquals(3, test.maxEnvelopes(envelopes));
  }
}
