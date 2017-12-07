package fb;

import utils.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimumCover {
    public List<Interval> minCover(List<Interval> intervals, Interval target) {
        List<Interval> result = new ArrayList<>();

        intervals.sort(Comparator.comparingInt(a -> a.start));

        int index = 0;
        while (index < intervals.size() && intervals.get(index).end < target.start) {
            index++;
        }

        if (index == intervals.size()) {
            return null;
        }

        int lastCover = target.start;

        for (int i = index; i < intervals.size(); i++) {
            if ((result.isEmpty() && intervals.get(i).start > lastCover) ||
                    !result.isEmpty() && intervals.get(i).start > result.get(result.size() - 1).end) {
                return null;
            }

            if (result.isEmpty() || intervals.get(i).end >= result.get(result.size() - 1).end) {
                result.add(intervals.get(i));
                if (result.size() > 1 && result.get(result.size() - 1).start <= lastCover) {
                    result.remove(result.size() - 2);
                }
            }

            if (result.size() >= 2) {
                lastCover = result.get(result.size() - 2).end;
            }

            if (result.get(result.size() - 1).end >= target.end) {
                return result;
            }
        }
        return null;
    }
}
