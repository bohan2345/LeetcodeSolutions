package math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 2/17/2016.
 *
 * @author Bohan Zheng
 */
public class SqrtTest {
    @Test
    public void test() {
        Sqrt test = new Sqrt();
        assertEquals(4, test.mySqrt(16));
    }

    @Test
    public void test2() {
        Sqrt test = new Sqrt();
        assertEquals(0, test.mySqrt(0));
    }

    @Test
    public void test3() {
        Sqrt test = new Sqrt();
        assertEquals(1, test.mySqrt(1));
    }

    @Test
    public void test4() {
        Sqrt test = new Sqrt();
        assertEquals(2, test.mySqrt(6));
    }

    @Test
    public void test5() {
        Sqrt test = new Sqrt();
        assertEquals(46339, test.mySqrt(2147395599));
    }
}
