package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 2/20/16.
 *
 * @author Bohan Zheng
 */
public class RomantoIntegerTest {
    @Test
    public void test() {
        RomantoInteger test = new RomantoInteger();
        assertEquals(99, test.romanToInt("XCIX"));
    }
}