package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 6/30/2016.
 *
 * @author Bohan Zheng
 */
public class AddTwoStringNumberTest {
    @Test
    public void test() {
        AddTwoStringNumber test = new AddTwoStringNumber();
        assertEquals("2222", test.add("2211", "11"));
    }

    @Test
    public void test2() {
        AddTwoStringNumber test = new AddTwoStringNumber();
        assertEquals("-2222", test.add("-2211", "-11"));
    }

    @Test
    public void test3() {
        AddTwoStringNumber test = new AddTwoStringNumber();
        assertEquals("2200", test.add("2211", "-11"));
    }

    @Test
    public void test4() {
        AddTwoStringNumber test = new AddTwoStringNumber();
        assertEquals("-2200", test.add("-2211", "11"));
    }

    @Test
    public void test5() {
        AddTwoStringNumber test = new AddTwoStringNumber();
        assertEquals("0", test.add("-11", "11"));
    }
}
