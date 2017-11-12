package fb;

import org.junit.Test;
import utils.Interval;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class FindMeetingTimeTest {
    @Test
    public void test() {
        FindMeetingTime test = new FindMeetingTime();

        List<Interval> intervals = Arrays.asList(new Interval(8, 10), new Interval(9, 13), new Interval(14, 15));

        List<Interval> meetingTimes = test.findMeetingTime(new Interval(9, 15), intervals);

        assertThat(meetingTimes).containsExactly(new Interval(13, 14));
    }

    @Test
    public void test2() {
        FindMeetingTime test = new FindMeetingTime();

        List<Interval> intervals = Arrays.asList(new Interval(8, 9), new Interval(13, 14));

        List<Interval> meetingTimes = test.findMeetingTime(new Interval(10, 12), intervals);

        assertThat(meetingTimes).containsExactly(new Interval(10, 12));
    }

    @Test
    public void test3() {
        FindMeetingTime test = new FindMeetingTime();

        List<Interval> intervals = Arrays.asList(new Interval(8, 10), new Interval(9, 13), new Interval(14, 15));

        List<Interval> meetingTimes = test.findMeetingTime(new Interval(7, 16), intervals);

        assertThat(meetingTimes).containsExactly(new Interval(7, 8), new Interval(13, 14), new Interval(15, 16));
    }
}
