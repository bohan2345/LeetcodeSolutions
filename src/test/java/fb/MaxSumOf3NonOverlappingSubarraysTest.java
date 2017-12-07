package fb;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class MaxSumOf3NonOverlappingSubarraysTest {
    @Test
    public void test() {
        int[] array = {1, 2, 1, 2, 6, 7, 5, 1};
        int k = 2;
        MaxSumOf3NonOverlappingSubarrays test = new MaxSumOf3NonOverlappingSubarrays();

        assertThat(test.maxSumOfThreeSubarrays(array, k)).isEqualTo(test.getSum(array, k));
    }
}
