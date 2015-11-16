package test.array;

import main.array.LongestConsecutiveSequence;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 11/15/15.
 *
 * @author Bohan Zheng
 */
public class LongestConsecutiveSequenceTest {
    LongestConsecutiveSequence test = new LongestConsecutiveSequence();

    @Test
    public void test() {
        int[] arrays = {100, 4, 200, 1, 3, 2};
        assertEquals(4, test.longestConsecutive(arrays));
    }
}