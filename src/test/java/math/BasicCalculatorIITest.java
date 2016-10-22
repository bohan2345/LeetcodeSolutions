package math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 4/26/2016.
 *
 * @author Bohan Zheng
 */
public class BasicCalculatorIITest {
    @Test
    public void test() {
        BasicCalculatorII test = new BasicCalculatorII();
        assertEquals(7, test.calculate("3   +2*2"));
    }

    @Test
    public void test2() {
        BasicCalculatorII test = new BasicCalculatorII();
        assertEquals(2, test.calculate("2+2/2*2-2"));
    }

    @Test
    public void test3() {
        BasicCalculatorII test = new BasicCalculatorII();
        assertEquals(5, test.calculate(" 3+5 / 2 "));
    }
}
