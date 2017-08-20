package google;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class NextGreaterElementIITest {
    private NextGreaterElementII test = new NextGreaterElementII();

    @Test
    public void test() {
        int[] nums = {1, 2, 1};

        int[] next = test.nextGreaterElements(nums);

        assertThat(next).isEqualTo(new int[]{2, -1, 2});
    }
}
