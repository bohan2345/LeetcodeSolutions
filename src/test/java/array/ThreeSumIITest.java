package array;

import org.junit.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class ThreeSumIITest {
    @Test
    public void test() {
        ThreeSumII test = new ThreeSumII();
        int[] nums = {1};

        List<List<Integer>> res = test.threeSumDuplicateReused(nums, 3);

        assertThat(res).hasSize(1);
        assertThat(res.get(0)).containsExactly(1, 1, 1);
    }

    @Test
    public void test2() {
        ThreeSumII test = new ThreeSumII();
        int[] nums = {1};

        List<List<Integer>> res = test.threeSumDuplicateReused(nums, 4);

        assertThat(res).isEmpty();
    }

    @Test
    public void test3() {
        ThreeSumII test = new ThreeSumII();
        int[] nums = {0};

        List<List<Integer>> res = test.threeSumDuplicateReused(nums, 4);

        assertThat(res).isEmpty();
    }

    @Test
    public void test4() {
        ThreeSumII test = new ThreeSumII();
        int[] nums = {1, 1, 1, 2, 1, 3};

        List<List<Integer>> res = test.threeSumDuplicateReused(nums, 4);

        assertThat(res).hasSize(1);
        assertThat(res.get(0)).containsExactly(1, 1, 2);
    }
}
