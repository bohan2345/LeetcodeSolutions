package google.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by bohan on 8/30/2016.
 *
 * @author Bohan Zheng
 */
public class PalindromePartitioningIITest {
    @Test
    public void test() {
        PalindromePartitioningII test = new PalindromePartitioningII();
        Assert.assertEquals(1, test.minCut("aab"));
    }
}
