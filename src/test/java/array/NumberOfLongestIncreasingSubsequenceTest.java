package array;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class NumberOfLongestIncreasingSubsequenceTest {
    @Test
    public void test() {
        NumberOfLongestIncreasingSubsequence test = new NumberOfLongestIncreasingSubsequence();
        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        assertThat(test.findNumberOfLIS(nums)).isEqualTo(3);
    }

    @Test
    public void test2() {
        NumberOfLongestIncreasingSubsequence test = new NumberOfLongestIncreasingSubsequence();
        int[] nums = {2, 2, 2};
        assertThat(test.findNumberOfLIS(nums)).isEqualTo(3);
    }
}
