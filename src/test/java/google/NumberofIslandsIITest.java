package google;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Assert;
import org.junit.Test;

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
//        int[] x = {0,0};
//        HashSet<int[]> xx = new HashSet<>();
//        xx.add(new int[]{0,0});
//        System.out.print(xx.contains(x));

        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        Assert.assertThat(test.numIslands2(3, 3, positions), IsIterableContainingInOrder.contains(1, 1, 2, 3));
    }
}
