package test.array;

import main.array.Triangle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <br>
 * Created by Bohan Zheng on 10/6/2015.
 *
 * @author Bohan Zheng
 */
public class TriangleTest {
    Triangle test = new Triangle();

    @Test
    public void test() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(5, 6, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        assertEquals(11, test.minimumTotal(triangle));
    }
}
