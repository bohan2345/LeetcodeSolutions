package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 5/12/2016.
 *
 * @author Bohan Zheng
 */
public class EditDistanceTest {
    @Test
    public void test() {
        EditDistance test = new EditDistance();
        assertEquals(1, test.minDistance("asdf", "asff"));
    }

    @Test
    public void test2() {
        EditDistance test = new EditDistance();
        assertEquals(1, test.minDistance("asdf", "asf"));
    }

    @Test
    public void test3() {
        EditDistance test = new EditDistance();
        assertEquals(3, test.minDistance("asf", ""));
    }

    @Test
    public void test4() {
        EditDistance test = new EditDistance();
        assertEquals(2, test.minDistance("ab", "bc"));
    }
}
