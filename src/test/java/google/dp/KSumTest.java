package google.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 6/25/16.
 *
 * @author Bohan Zheng
 */
public class KSumTest {
    @Test
    public void test() {
        KSum test = new KSum();
        int[] A = {1,2,3,4};
        Assert.assertEquals(2, test.kSum(A, 2, 5));
    }
}
