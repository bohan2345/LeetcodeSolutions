package array;

import utils.Interval;

import java.util.ArrayList;
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

    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (newInterval == null) {
                result.add(interval);
                continue;
            }
            if (interval.start <= newInterval.end && interval.end >= newInterval.start) {
                // merge interval and newInterval then insert into result
                newInterval = merge(interval, newInterval);
            } else {
                if (interval.start < newInterval.start) {
                    result.add(interval);
                } else {
                    result.add(newInterval);
                    i--;
                    newInterval = null;
                }
            }
        }
        if (newInterval != null) {
            result.add(newInterval);
        }
        return result;
    }

    private Interval merge(Interval i1, Interval i2) {
        Interval newInterval = new Interval();
        newInterval.start = Math.min(i1.start, i2.start);
        newInterval.end = Math.max(i1.end, i2.end);
        return newInterval;
    }

    public List<Interval> insert3(List<Interval> intervals, Interval newInterval) {
        if (intervals.isEmpty()) {
            intervals.add(newInterval);
            return intervals;
        }
        List<Interval> result = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.end < newInterval.start) {
                index++;
                result.add(interval);
                continue;
            }
            if (interval.start > newInterval.end) {
                result.add(interval);
                continue;
            }

            if (newInterval.start >= interval.start) {
                newInterval.start = interval.start;
            }
            if (newInterval.end <= interval.end) {
                newInterval.end = interval.end;
            }
        }
        result.add(index, newInterval);
        return result;
    }
}
