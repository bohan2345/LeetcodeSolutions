package test.array;

import main.array.CombinationSumIII;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * <p>
 * Created by Bohan Zheng on 11/27/2015.
 *
 * @author Bohan Zheng
 */
public class CombinationSumIIITest {
    CombinationSumIII test = new CombinationSumIII();

    @Test
    public void test() {
        List<List<Integer>> expected = new ArrayList<>(3);
        expected.add(Arrays.asList(1, 2, 6));
        expected.add(Arrays.asList(1, 3, 5));
        expected.add(Arrays.asList(2, 3, 4));

        assertThat(test.combinationSum3(3, 9), IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }
}
