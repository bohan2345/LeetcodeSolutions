package google;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 5/23/2016.
 *
 * @author Bohan Zheng
 */
public class NumberofIslandsIITest {
    @Test
    public void test() {
        NumberofIslandsII test = new NumberofIslandsII();
        List<NumberofIslandsII.Position> positions = new ArrayList<>();
        positions.add(new NumberofIslandsII.Position(0, 0));
        positions.add(new NumberofIslandsII.Position(0, 1));
        positions.add(new NumberofIslandsII.Position(1, 2));
        positions.add(new NumberofIslandsII.Position(2, 1));
        assertThat(test.numIslands2(3, 3, positions), IsIterableContainingInOrder.contains(1, 1, 2, 3));
    }
}
