package string;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 3/10/2016.
 *
 * @author Bohan Zheng
 */
public class WildcardMatchingTest {
    WildcardMatching test = new WildcardMatching();

    @Test
    public void test() {
        assertTrue(test.isMatch("abc", "abc"));
    }

    @Test
    public void test2() {
        assertTrue(test.isMatch("abc", "a?c"));
    }

    @Test
    public void test3() {
        assertTrue(test.isMatch("abc", "a*"));
    }

    @Test
    public void test4() {
        assertTrue(test.isMatch("abc", "*"));
    }

    @Test
    public void test5() {
        assertTrue(test.isMatch("abc", "a*b*c"));
    }

    @Test
    public void test6() {
        assertTrue(!test.isMatch("abc", "c*b*c*"));
    }
}
