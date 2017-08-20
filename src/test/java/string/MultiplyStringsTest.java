package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 5/5/2016.
 *
 * @author Bohan Zheng
 */
public class MultiplyStringsTest {
    @Test
    public void test() {
        MultiplyStrings test = new MultiplyStrings();
        assertEquals("484", test.multiply("22", "22"));
    }

    @Test
    public void test2() {
        MultiplyStrings test = new MultiplyStrings();
        assertEquals("15185088", test.multiply("123456", "123"));
    }
}
