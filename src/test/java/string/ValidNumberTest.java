package string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 4/14/2016.
 *
 * @author Bohan Zheng
 */
public class ValidNumberTest {
    @Test
    public void test() {
        ValidNumber test = new ValidNumber();
        assertTrue(test.isNumber("1 "));
    }

    @Test
    public void test2() {
        ValidNumber test = new ValidNumber();
        assertTrue(test.isNumber("1e2"));
    }

    @Test
    public void test3() {
        ValidNumber test = new ValidNumber();
        assertTrue(test.isNumber(".1"));
    }

    @Test
    public void test4() {
        ValidNumber test = new ValidNumber();
        assertTrue(test.isNumber("-.1"));
    }

    @Test
    public void test5() {
        ValidNumber test = new ValidNumber();
        assertTrue(test.isNumber("1e-1"));
    }

    @Test
    public void test6() {
        ValidNumber test = new ValidNumber();
        assertFalse(test.isNumber("1e-1a"));
    }

    @Test
    public void test7() {
        ValidNumber test = new ValidNumber();
        assertFalse(test.isNumber(".e1"));
    }

    @Test
    public void test8() {
        ValidNumber test = new ValidNumber();
        assertFalse(test.isNumber(".1e+"));
    }

    @Test
    public void test9() {
        ValidNumber test = new ValidNumber();
        assertTrue(test.isNumber("1.e1"));
    }

    @Test
    public void test10() {
        ValidNumber test = new ValidNumber();
        assertFalse(test.isNumber("-e58 "));
    }

    @Test
    public void test11() {
        ValidNumber test = new ValidNumber();
        assertFalse(test.isNumber("11e"));
    }
}
