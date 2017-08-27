package string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AddBoldTagInString {
    public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = new ArrayList<>();

        for (String d : dict) {
            int index = s.indexOf(d);
            while (index != -1) {
                intervals.add(new Interval(index, index + d.length()));
                index = s.indexOf(d, index + 1);
            }
        }

        StringBuilder sb = new StringBuilder(s);
        intervals = merge(intervals);
        for (int i = intervals.size() - 1; i >= 0; i--) {
            Interval interval = intervals.get(i);
            sb.insert(interval.end, "</b>");
            sb.insert(interval.start, "<b>");
        }

        return sb.toString();
    }

    private List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));
        int index = 0;

        while (index < intervals.size() - 1) {
            Interval thisInterval = intervals.get(index);
            Interval nextInterval = intervals.get(index + 1);

            if (nextInterval.start > thisInterval.end) {
                index++;
            } else if (nextInterval.end > thisInterval.end) {
                intervals.remove(index + 1);
                thisInterval.end = nextInterval.end;
            } else {
                intervals.remove(index + 1);
            }
        }
        return intervals;
    }

    class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}

