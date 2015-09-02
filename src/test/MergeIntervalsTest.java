package test;

import array.MergeIntervals;
import org.junit.Test;
import utils.Interval;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <br>
 * Created by Bohan Zheng on 9/2/2015.
 *
 * @author Bohan Zheng
 */
public class MergeIntervalsTest {
    @Test
    public void test() {
        MergeIntervals test = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1, 6));
        expected.add(new Interval(8, 10));
        expected.add(new Interval(15, 18));
        assertEquals(expected, test.merge(intervals));
    }
    @Test
    public void test2() {
        MergeIntervals test = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(1, 4));

        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1, 4));
        assertEquals(expected, test.merge(intervals));
    }
    @Test
    public void test3() {
        MergeIntervals test = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(4, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 9));
        intervals.add(new Interval(1, 10));

        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1, 10));
        assertEquals(expected, test.merge(intervals));
    }
}
