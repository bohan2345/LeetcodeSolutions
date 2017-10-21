package google;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class FirstNumberLargerThanSelfTest {
    @Test
    public void test() {
        FirstNumberLargerThanSelf test = new FirstNumberLargerThanSelf();
        int[] array = {71, 74, 72, 73, 75};

        int[] res = test.firstLargeIndex(array);

        assertThat(res).isEqualTo(new int[]{1, 4, 3, 4, -1});
    }


    @Test
    public void test2() {
        FirstNumberLargerThanSelf test = new FirstNumberLargerThanSelf();
        int[] nums = {5, 4, 3, 2, 1};

        int[] res = test.firstLargeIndex(nums);

        assertThat(res).isEqualTo(new int[]{-1, -1, -1, -1, -1});
    }
}
