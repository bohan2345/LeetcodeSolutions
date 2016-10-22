package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 5/11/2016.
 *
 * @author Bohan Zheng
 */
public class MinimumWindowSubstringTest {
    @Test
    public void test() {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        assertEquals("BANC", test.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void test2() {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        assertEquals("", test.minWindow("ADOBECODEBANC", "ABCZ"));
    }

    @Test
    public void test3() {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        assertEquals("cabd", test.minWindow("abcabdebac", "cda"));
    }

    @Test
    public void test4() {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        assertEquals("adobecodeba", test.minWindow("adobecodebanc", "abcda"));
    }
}
