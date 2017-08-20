package string;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

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
        assertTrue(test.isMatchII("abc", "abc"));
    }

    @Test
    public void test2() {
        assertTrue(test.isMatch("abc", "a?c"));
    }

    @Test
    public void test3() {
        assertTrue(test.isMatchII("abc", "a*"));
    }

    @Test
    public void test4() {
        assertTrue(test.isMatchII("abc", "*"));
    }

    @Test
    public void test5() {
        assertTrue(test.isMatchII("abc", "a*b*c"));
    }

    @Test
    public void test6() {
        assertTrue(!test.isMatchII("abc", "c*b*c*"));
    }

    @Test
    public void test7() {
        assertTrue(!test.isMatchII("aa", "a"));
    }

    @Test
    public void test9() {
        assertTrue(!test.isMatchII("aba", "a*b"));
    }

    @Test
    public void test8() {
        assertTrue(!test.isMatchII("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a********b"));
    }
}
