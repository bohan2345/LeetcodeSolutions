package google;

import static org.junit.Assert.*;

import org.junit.Test;

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
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        assertEquals(0, test.maxEnvelopes(envelopes));
    }
}
