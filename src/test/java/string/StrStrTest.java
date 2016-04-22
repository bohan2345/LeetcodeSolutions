package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 4/21/2016.
 *
 * @author Bohan Zheng
 */
public class StrStrTest {
    @Test
    public void test() {
        StrStr test = new StrStr();
        assertEquals(15, test.strStr("ABC ABCDAB ABCDABCDABDE", "ABCDABD"));
    }

    @Test
    public void test2() {
        StrStr test = new StrStr();
        assertEquals(0, test.strStr("AB", "AB"));
    }

    @Test
    public void test3() {
        StrStr test = new StrStr();
        assertEquals(-1, test.strStr("AB", "C"));
    }
}
