package google;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 6/12/2016.
 *
 * @author Bohan Zheng
 */
public class TopologicalSortTest {
    @Test
    public void test() {
        TopologicalSort test = new TopologicalSort();
        List<String> strs = new ArrayList<>(Arrays.asList(
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"));

        assertThat(test.alienDictionary(strs), IsIterableContainingInOrder.contains('w', 'e', 'r', 'f', 't'));
    }
}
