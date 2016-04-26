package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * <p>
 * Created by Bohan Zheng on 4/25/2016.
 *
 * @author Bohan Zheng
 */
public class AddBinaryTest {

    @Test
    public void test() {
        AddBinary test = new AddBinary();
        Assert.assertEquals("110", test.addBinary("11", "11"));
    }
}