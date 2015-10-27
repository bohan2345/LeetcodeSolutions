package test.array;

import main.array.PascalsTriangle;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 10/27/2015.
 *
 * @author Bohan Zheng
 */
public class PascalsTriangleTest {
    PascalsTriangle test = new PascalsTriangle();

    @Test
    public void test() {
        List<List<Integer>> expected = new ArrayList<>(5);
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(1, 1));
        expected.add(Arrays.asList(1, 2, 1));
        expected.add(Arrays.asList(1, 3, 3, 1));
        expected.add(Arrays.asList(1, 4, 6, 4, 1));
        assertEquals(0, 0);
        assertThat(test.generate(5), IsIterableContainingInOrder.contains(expected.toArray()));
    }
}
