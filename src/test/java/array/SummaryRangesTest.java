package array;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 10/7/2015.
 *
 * @author Bohan Zheng
 */
public class SummaryRangesTest {
    SummaryRanges test = new SummaryRanges();

    @Test
    public void test() {
        List<String> expected = Arrays.asList("0->2", "4->5", "7");
        List<String> actual = test.summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
    }
}
