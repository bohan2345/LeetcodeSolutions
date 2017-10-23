package google;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class ChangeOneNumberToIncreasingArrayTest {
    @Test
    public void test() {
        ChangeOneNumberToIncreasingArray test = new ChangeOneNumberToIncreasingArray();
        int[] nums = {1, 2, 3, 4, 8, 4, 5, 6};

        assertThat(test.oneNumberChangeToIncreasingArray(nums)).isEqualTo(4);
    }

    @Test
    public void test2() {
        ChangeOneNumberToIncreasingArray test = new ChangeOneNumberToIncreasingArray();
        int[] nums = {1, 2, 3, 4, 1, 4, 5, 6};

        assertThat(test.oneNumberChangeToIncreasingArray(nums)).isEqualTo(4);
    }

    @Test
    public void test3() {
        ChangeOneNumberToIncreasingArray test = new ChangeOneNumberToIncreasingArray();
        int[] nums = {1, 2, 3, 4, 5, 1, 2, 3};

        assertThat(test.oneNumberChangeToIncreasingArray(nums)).isEqualTo(-1);
    }

    @Test
    public void test4() {
        ChangeOneNumberToIncreasingArray test = new ChangeOneNumberToIncreasingArray();
        int[] nums = {3, 3, 2, 2};

        assertThat(test.oneNumberChangeToIncreasingArray(nums)).isEqualTo(-1);
    }

    @Test
    public void test5() {
        ChangeOneNumberToIncreasingArray test = new ChangeOneNumberToIncreasingArray();
        int[] nums = {2, 1};

        assertThat(test.oneNumberChangeToIncreasingArray(nums)).isEqualTo(0);
    }

    @Test
    public void test6() {
        ChangeOneNumberToIncreasingArray test = new ChangeOneNumberToIncreasingArray();
        int[] nums = {1, 2, 3, 4, 5};

        assertThat(test.oneNumberChangeToIncreasingArray(nums)).isEqualTo(0);
    }
}
