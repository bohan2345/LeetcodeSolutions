package miscellany;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 3/8/2016.
 *
 * @author Bohan Zheng
 */
public class ValidJsonTest {
    @Test
    public void test() {
        ValidJson test = new ValidJson();
        assertTrue(test.isValid("{ a : a }"));
    }

    @Test
    public void test2() {
        ValidJson test = new ValidJson();
        assertTrue(test.isValid("{a :a, c: d }"));
    }

    @Test
    public void test3() {
        ValidJson test = new ValidJson();
        assertTrue(test.isValid("{a: a, c:{ e: f}}"));
    }

    @Test
    public void test4() {
        ValidJson test = new ValidJson();
        assertFalse(test.isValid("{{a:a}}"));
    }

    @Test
    public void test5() {
        ValidJson test = new ValidJson();
        assertFalse(test.isValid("{a}"));
    }

    @Test
    public void test6() {
        ValidJson test = new ValidJson();
        assertTrue(test.isValid("[{a:a}, {b:b, c:c}]"));
    }
}
