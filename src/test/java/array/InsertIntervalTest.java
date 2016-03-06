package array;

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
public class InsertIntervalTest {
    @Test
    public void testInsertHelper() {
        InsertInterval test = new InsertInterval();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        Interval newInterval = new Interval(2, 5);

        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1, 3));
        expected.add(new Interval(2, 5));
        expected.add(new Interval(6, 9));

        assertEquals(1, test.insertHelper(intervals, newInterval));
        assertEquals(expected, intervals);
    }

    @Test
    public void testInsertHelper2() {
        InsertInterval test = new InsertInterval();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
        Interval newInterval = new Interval(0, 3);

        assertEquals(0, test.insertHelper(intervals, newInterval));
    }

    @Test
    public void testInsert() {
        InsertInterval test = new InsertInterval();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        Interval newInterval = new Interval(2, 5);

        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1, 5));
        expected.add(new Interval(6, 9));

        assertEquals(expected, test.insert2(intervals, newInterval));
    }

    @Test
    public void testInsert2() {
        InsertInterval test = new InsertInterval();
        List<Interval> intervals = new ArrayList<>();
        Interval newInterval = new Interval(2, 5);

        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(2, 5));

        assertEquals(expected, test.insert(intervals, newInterval));
    }

    @Test
    public void testInsert3() {
        InsertInterval test = new InsertInterval();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
        Interval newInterval = new Interval(2, 3);

        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1, 5));

        assertEquals(expected, test.insert(intervals, newInterval));
    }

    @Test
    public void testInsert4() {
        InsertInterval test = new InsertInterval();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
        Interval newInterval = new Interval(2, 3);

        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1, 5));

        assertEquals(expected, test.insert2(intervals, newInterval));
    }
}
