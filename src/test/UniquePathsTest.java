package test;

import array.UniquePaths;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <br>
 * Created by Bohan Zheng on 9/2/2015.
 *
 * @author Bohan Zheng
 */
public class UniquePathsTest {
    UniquePaths test = new UniquePaths();

    @Test
    public void test() {
        assertEquals(1, test.uniquePaths(1, 1));
    }

    @Test
    public void test2() {
        assertEquals(3, test.uniquePaths(3, 2));
    }

    @Test
    public void test3() {
        assertEquals(6, test.uniquePaths(3, 3));
    }

}
