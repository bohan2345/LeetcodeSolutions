package google;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 6/8/2016.
 *
 * @author Bohan Zheng
 */
public class TheSkylineProblemTest {
    @Test
    public void test() {
        TheSkylineProblem test = new TheSkylineProblem();
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<int[]> actual = test.getSkyline(buildings);
        int[][] expect = {{2, 10}, {3, 15}, {7, 12}, {12, 0}, {15, 10}, {20, 8}, {24, 0}};
        assertThat(actual, IsIterableContainingInOrder.contains(expect));
    }
}
