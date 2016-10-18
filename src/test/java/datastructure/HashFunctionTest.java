package datastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 10/17/16.
 *
 * @author Bohan Zheng
 */
public class HashFunctionTest {
    @Test
    public void test() {
        HashFunction test = new HashFunction();
        char[] key = "abcd".toCharArray();
        assertEquals(78, test.hashCode(key, 100));
    }
}