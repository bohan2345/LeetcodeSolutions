package string;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 3/29/2016.
 *
 * @author Bohan Zheng
 */
public class ReverseWordsinaStringTest {
    @Test
    public void test() {
        ReverseWordsinaString test = new ReverseWordsinaString();
        assertEquals("blue is sky the", test.reverseWords("the sky is blue"));
    }

    @Test
    public void test2() {
        ReverseWordsinaString test = new ReverseWordsinaString();
        assertEquals("blue is sky the", test.reverseWords("the sky       is blue"));
    }
}
