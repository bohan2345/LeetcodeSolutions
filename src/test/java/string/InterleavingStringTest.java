package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by bohan on 8/31/2016.
 *
 * @author Bohan Zheng
 */
public class InterleavingStringTest {
    @Test
    public void test() {
        InterleavingString test = new InterleavingString();
        Assert.assertTrue(test.isInterleave("abcd", "efgh", "abcdefgh"));
    }

    @Test
    public void test2() {
        InterleavingString test = new InterleavingString();
        Assert.assertTrue(test.isInterleave("abcd", "efgh", "aebfcgdh"));
    }

    @Test
    public void test3() {
        InterleavingString test = new InterleavingString();
        Assert.assertFalse(test.isInterleave("abbcddef", "accbbbcd", "abbcddefaccbbbdc"));
    }
}
