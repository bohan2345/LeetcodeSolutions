package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void test2() {
        ShortestPalindrome test = new ShortestPalindrome();
        assertEquals("abcdadcba", test.shortestPalindrome("adcba"));
    }

    @Test
    public void test3() {
        ShortestPalindrome test = new ShortestPalindrome();
        assertEquals("cdabadc", test.shortestPalindrome2("abadc"));
    }

    @Test
    public void test4() {
        ShortestPalindrome test = new ShortestPalindrome();
        assertEquals("aba", test.shortestPalindrome2("ba"));
    }

    @Test
    public void test5() {
        ShortestPalindrome test = new ShortestPalindrome();
        assertEquals("baab", test.shortestPalindrome2("aab"));
    }
//    @Test
//    public void test6() {
//        ShortestPalindrome test = new ShortestPalindrome();
//        assertEquals("baababbabaab", test.shortestPalindrome3("abbabaab"));
//    }
//    @Test
//    public void test7() {
//        ShortestPalindrome test = new ShortestPalindrome();
//        assertEquals("aaacecaaa", test.shortestPalindrome3("aacecaaa"));
//    }
}
