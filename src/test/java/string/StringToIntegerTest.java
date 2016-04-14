package string;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 4/4/2016.
 *
 * @author Bohan Zheng
 */
public class StringToIntegerTest {
    @Test
    public void test() {
        StringToInteger test = new StringToInteger();
        assertEquals("sdf", 0, test.myAtoi("sdf"));
        assertEquals("", 0, test.myAtoi(""));
        assertEquals("0", 0, test.myAtoi("0"));
        assertEquals("123", 123, test.myAtoi("   0123"));
        assertEquals("Integer.MAX_VALUE", Integer.MAX_VALUE, test.myAtoi("222222222222222222222222222222222222222"));
        assertEquals("Integer.MIN_VALUE", Integer.MIN_VALUE, test.myAtoi("-222222222222222222222222222222222222222"));
        assertEquals("-1", -1, test.myAtoi("-00000000001"));
    }
    @Test
    public void test2() {
        StringToInteger test = new StringToInteger();
        assertEquals("+-2", 0, test.myAtoi("+-2"));
    }
    @Test
    public void test3() {
        StringToInteger test = new StringToInteger();
        assertEquals("    010", 10, test.myAtoi("    010"));
    }
}
