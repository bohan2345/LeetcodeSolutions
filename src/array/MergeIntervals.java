package array;

import utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.<br>
 * For example,<br>
 * Given [1,3],[2,6],[8,10],[15,18],<br>
 * return [1,6],[8,10],[15,18].
 * <br>
 * Created by Bohan Zheng on 9/2/2015.
 *
 * @author Bohan Zheng
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start > o2.start) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        List<Interval> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.size()) {
            Interval newInterval = new Interval(intervals.get(i).start, intervals.get(i).end);
            i++;
            while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
                newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
                i++;
            }
            res.add(newInterval);
        }
        return res;
    }
}
