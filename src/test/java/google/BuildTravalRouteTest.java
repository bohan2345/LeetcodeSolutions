package google;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 5/19/2016.
 *
 * @author Bohan Zheng
 */
public class BuildTravalRouteTest {
    @Test
    public void test() {
        BuildTravalRoute test = new BuildTravalRoute();
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("MUC", "LHR"));
        input.add(Arrays.asList("JFK", "MUC"));
        input.add(Arrays.asList("SFO", "SJC"));
        input.add(Arrays.asList("LHR", "SFO"));
        assertThat(test.buildRoute(input), IsIterableContainingInOrder.contains("JFK", "MUC", "LHR", "SFO", "SJC"));
    }
}
