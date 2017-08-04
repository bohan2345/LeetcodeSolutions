package array;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class MissingRangesTest {
    @Test
    public void test() {
        MissingRanges test = new MissingRanges();
        int[] nums = {0, 1, 3, 50, 75};
        assertThat(test.findMissingRanges(nums, 0, 99)).containsExactly("2", "4->49", "51->74", "76->99");
    }

    @Test
    public void test2() {
        MissingRanges test = new MissingRanges();
        int[] nums = {};
        assertThat(test.findMissingRanges(nums, 0, 99)).containsExactly("0->99");
    }

    @Test
    public void test3() {
        MissingRanges test = new MissingRanges();
        int[] nums = {4};
        assertThat(test.findMissingRanges(nums, 0, 99)).containsExactly("0->3", "5->99");
    }

    @Test
    public void test4() {
        MissingRanges test = new MissingRanges();
        int[] nums = {4};
        assertThat(test.findMissingRanges(nums, 7, 99)).containsExactly("7->99");
    }
}
