package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 4/25/2016.
 *
 * @author Bohan Zheng
 */
public class ReverseVowelsofaStringTest {
    @Test
    public void test() {
        ReverseVowelsofaString test = new ReverseVowelsofaString();
        assertEquals("leotcede", test.reverseVowels("leetcode"));
    }

    @Test
    public void test2() {
        ReverseVowelsofaString test = new ReverseVowelsofaString();
        assertEquals(".,", test.reverseVowels(".,"));
    }
}
