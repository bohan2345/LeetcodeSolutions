package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 3/1/2016.
 *
 * @author Bohan Zheng
 */
public class ZigZagConversionTest {
    @Test
    public void test() {
        ZigZagConversion test = new ZigZagConversion();
        assertEquals("PAHNAPLSIIGYIR", test.convert("PAYPALISHIRING", 3));
    }

    @Test
    public void test2() {
        ZigZagConversion test = new ZigZagConversion();
        assertEquals("A", test.convert("A", 1));
    }
}
