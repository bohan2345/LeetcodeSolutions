package google;

import org.junit.Assert;
import org.junit.Test;
import utils.GraphNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Created by Bohan Zheng on 6/30/2016.
 *
 * @author Bohan Zheng
 */
public class DetectCycleTest {
    @Test
    public void test() {
        DetectCycle test = new DetectCycle();
        GraphNode a = new GraphNode(1);
        GraphNode b = new GraphNode(2);
        GraphNode c = new GraphNode(3);
        GraphNode d = new GraphNode(4);
        a.adjcents.add(b);
        a.adjcents.add(c);
        c.adjcents.add(d);
        d.adjcents.add(b);
        Assert.assertFalse(test.detectCycle(c, b, d, a));
    }

    @Test
    public void test2() {
        DetectCycle test = new DetectCycle();
        GraphNode a = new GraphNode(1);
        GraphNode b = new GraphNode(2);
        GraphNode c = new GraphNode(3);
        GraphNode d = new GraphNode(4);
        a.adjcents.add(b);
        b.adjcents.add(c);
        c.adjcents.add(d);
        d.adjcents.add(a);
        Assert.assertTrue(test.detectCycle(c, b, d, a));
    }

    @Test
    public void test3() {
        DetectCycle test = new DetectCycle();
        GraphNode a = new GraphNode(1);
        GraphNode b = new GraphNode(2);
        GraphNode c = new GraphNode(3);
        GraphNode d = new GraphNode(4);
        List<GraphNode[]> list = new ArrayList<>();
        list.add(new GraphNode[]{a, b});
        list.add(new GraphNode[]{a, c});
        list.add(new GraphNode[]{c, d});
        list.add(new GraphNode[]{d, b});
        Assert.assertFalse(test.detectCycle(list));
    }
}
