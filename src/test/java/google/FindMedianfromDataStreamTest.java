package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 6/10/2016.
 *
 * @author Bohan Zheng
 */
public class FindMedianfromDataStreamTest {
    @Test
    public void test() {
        FindMedianfromDataStream test = new FindMedianfromDataStream();
        test.addNum(1);
        assertEquals(1.0, test.findMedian(), 0);
        test.addNum(2);
        assertEquals(1.5, test.findMedian(), 0);
        test.addNum(3);
        assertEquals(2.0, test.findMedian(), 0);
        test.addNum(4);
        assertEquals(2.5, test.findMedian(), 0);
    }
}
