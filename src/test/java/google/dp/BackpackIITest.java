package google.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 6/23/2016.
 *
 * @author Bohan Zheng
 */
public class BackpackIITest {
    @Test
    public void test() {
        //100, [77,22,29,50,99], [92,22,87,46,90]
        BackpackII test = new BackpackII();
        int[] A = {2, 3, 5, 7};
        int[] V = {1, 5, 2, 4};
        assertEquals(9, test.backPackII(10, A, V));
    }

    @Test
    public void test2() {
        //100, [], []
        BackpackII test = new BackpackII();
        int[] A = {77,22,29,50,99};
        int[] V = {92,22,87,46,90};
        assertEquals(133, test.backPackII(100, A, V));
    }

    @Test
    public void test3() {
        //100, [], []
        BackpackII test = new BackpackII();
        int[] A = {79,58,86,11,28,62,15,68};
        int[] V = {83,14,54,79,72,52,48,62};
        assertEquals(261, test.backPackII(132, A, V));
    }
}
