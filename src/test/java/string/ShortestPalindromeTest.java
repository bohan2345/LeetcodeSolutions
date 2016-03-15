package string;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 3/14/2016.
 *
 * @author Bohan Zheng
 */
public class ShortestPalindromeTest {
    @Test
    public void test() {
        ShortestPalindrome test = new ShortestPalindrome();
        assertEquals("aaacecaaa", test.shortestPalindrome("aacecaaa"));
    }
}
