package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 4/27/2016.
 *
 * @author Bohan Zheng
 */
public class DecodeWaysTest {
    @Test
    public void test() {
        DecodeWays test = new DecodeWays();
        assertEquals(2, test.numDecodings("12"));
    }

    @Test
    public void test2() {
        DecodeWays test = new DecodeWays();
        assertEquals(1, test.numDecodings("120"));
    }

    @Test
    public void test3() {
        DecodeWays test = new DecodeWays();
        assertEquals(1, test.numDecodings("101"));
    }

    @Test
    public void test4() {
        DecodeWays test = new DecodeWays();
        assertEquals(0, test.numDecodings("01"));
    }

    @Test
    public void test5() {
        DecodeWays test = new DecodeWays();
        assertEquals(0, test.numDecodings("30"));
    }
}
