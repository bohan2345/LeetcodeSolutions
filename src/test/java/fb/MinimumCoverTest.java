package fb;


import org.junit.Test;
import utils.Interval;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;


public class MinimumCoverTest {
// [1,3], [3,5], [2,4], [4,7], [4,9], [7,12]
    @Test
    public void test1() {
        List<Interval> intervals = Arrays.asList(new Interval(1,3), new Interval(3,5), new Interval(2, 4), new Interval(4,7),
                new Interval(4,9), new Interval(7,12));

        Interval target = new Interval(2,9);
        MinimumCover mm = new MinimumCover();
        List<Interval> result = mm.minCover(intervals, target);
        assertThat(result).containsExactly(new Interval(2,4), new Interval(4,9));
    }


}
