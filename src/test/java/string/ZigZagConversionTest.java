package string;

import static org.junit.Assert.*;

import org.junit.Test;

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
}
