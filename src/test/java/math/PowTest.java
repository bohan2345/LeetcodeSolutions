package math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 2/17/2016.
 *
 * @author Bohan Zheng
 */
public class PowTest {
    @Test
    public void test() {
        Pow test = new Pow();
        assertEquals(8.0, test.myPow(2.0, 3), .01);
    }

    @Test
    public void test2() {
        Pow test = new Pow();
        assertEquals(0.125, test.myPow(2.0, -3), .01);
    }
}
