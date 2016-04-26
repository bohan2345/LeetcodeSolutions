package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 4/25/2016.
 *
 * @author Bohan Zheng
 */
public class CompareVersionNumbersTest {
    @Test
    public void test() {
        CompareVersionNumbers test = new CompareVersionNumbers();
        assertEquals(-1, test.compareVersion("1.1.2", "1.2.1"));
    }

    @Test
    public void test2() {
        CompareVersionNumbers test = new CompareVersionNumbers();
        assertEquals(1, test.compareVersion("1.1.2", "1.1.1"));
    }

    @Test
    public void test3() {
        CompareVersionNumbers test = new CompareVersionNumbers();
        assertEquals(0, test.compareVersion("1.0.0", "1"));
    }

    @Test
    public void test4() {
        CompareVersionNumbers test = new CompareVersionNumbers();
        assertEquals(0, test.compareVersion("1", "1.0"));
    }
}
