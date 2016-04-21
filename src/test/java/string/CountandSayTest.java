package string;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 4/21/2016.
 *
 * @author Bohan Zheng
 */
public class CountandSayTest {
    @Test
    public void test() {
        CountandSay test = new CountandSay();
        assertEquals("1", test.countAndSay(1));
    }
    @Test
    public void test2() {
        CountandSay test = new CountandSay();
        assertEquals("111221", test.countAndSay(5));
    }
}
