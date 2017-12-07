package fb;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class TaskSchedulerTest {
    @Test
    public void test2() {
        TaskScheduler test = new TaskScheduler();
        char[] task = "AAABBB".toCharArray();
        int n = 2;
        int x = test.leastInterval(task, n);

        assertThat(x).isEqualTo(8);

    }

    @Test
    public void test() {
        TaskScheduler test = new TaskScheduler();
        char[] task = "AAAAAABCDEFG".toCharArray();
        int n = 2;
        int x = test.leastInterval(task, n);

        assertThat(x).isEqualTo(16);

    }
}
