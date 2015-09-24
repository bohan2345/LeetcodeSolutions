package main.array;

import main.utils.Interval;

import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).<br>
 * You may assume that the intervals were initially sorted according to their start times.<br>
 * <b>Example 1:</b><br>
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].<br>
 * <b>Example 2:</b><br>
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].<br>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].<br>
 * <br>
 * Created by Bohan Zheng on 9/2/2015.
 *
 * @author Bohan Zheng
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = insertHelper(intervals, newInterval);

        if (i - 1 >= 0 && intervals.get(i - 1).end >= intervals.get(i).start) {
            Interval removed = intervals.remove(i - 1);
            i--;
            intervals.get(i).start = removed.start;
            intervals.get(i).end = Math.max(removed.end, intervals.get(i).end);
        }

        for (int j = i + 1; j < intervals.size() && intervals.get(j).start <= intervals.get(i).end; ) {
            Interval removed = intervals.remove(j);
            intervals.get(i).end = Math.max(intervals.get(i).end, removed.end);
        }
        return intervals;
    }

    public int insertHelper(List<Interval> intervals, Interval newInterval) {
        int left = 0, right = intervals.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals.get(mid).start == newInterval.start) {
                intervals.add(mid, newInterval);
                return mid;
            } else if (intervals.get(mid).start > newInterval.start) {
                if (mid == 0 || intervals.get(mid - 1).start < newInterval.start) {
                    intervals.add(mid, newInterval);
                    return mid;
                }
                right = mid - 1;
            } else {
                if (mid + 1 == intervals.size() || intervals.get(mid + 1).start > newInterval.start) {
                    intervals.add(mid + 1, newInterval);
                    return mid + 1;
                }
                left = mid + 1;
            }
        }
        intervals.add(newInterval);
        return 0;
    }
}
