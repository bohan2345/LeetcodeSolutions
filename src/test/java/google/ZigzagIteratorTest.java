package google;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 6/28/2016.
 *
 * @author Bohan Zheng
 */
public class ZigzagIteratorTest {
    @Test
    public void test() {
        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{1, 2, 3});
        list.add(new Integer[]{4, 5, 6, 7});
        list.add(new Integer[]{8, 9});
        ZigzagIterator<Integer> test = new ZigzagIterator<>(list);
        Integer[] res = {1,4,8,2,5,9,3,6,7};
        for(int i = 0; i < res.length; i++) {
            Assert.assertEquals(res[i], test.next());
        }
    }
}