package google;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RatioFinderTest {
    @Test
    public void test() {
        RatioFinder test = new RatioFinder();
        Map<String, List<RatioFinder.Edge>> graph = new HashMap<>();
        graph.put("A", ImmutableList.of(new RatioFinder.Edge("B", 0.8), new RatioFinder.Edge("D", 0.7)));
        graph.put("B", ImmutableList.of(new RatioFinder.Edge("A", 1 / 0.8), new RatioFinder.Edge("C", 0.7), new RatioFinder.Edge("D", 0.9)));
        graph.put("C", ImmutableList.of(new RatioFinder.Edge("B", 1 / 0.7)));
        graph.put("D", ImmutableList.of(new RatioFinder.Edge("A", 1 / 0.7), new RatioFinder.Edge("B", 0.9)));

        assertEquals(test.ratioFinder("A", "C", graph), 0.56, 0.0001);
        assertEquals(test.ratioFinder("A", "D", graph), 0.7, 0.0001);
        assertEquals(test.ratioFinder("A", "E", graph), -1.0, 0.0001);
    }
}
