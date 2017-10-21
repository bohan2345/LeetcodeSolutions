package google;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class KthSmallestDistancePairTest {
    @Test
    public void test() {
        KthSmallestDistancePair test = new KthSmallestDistancePair();
        int[] nums = {1, 4, 7, 23, 645, 3, 6, 20, 23};
        int k = 5;

        int[] pair = test.getKthPair(nums, k);


        assertThat(pair).asList()
                .containsExactlyElementsIn(test.kthSmallestAbsoluteDifferenceOfTwoElementsInAnArray(nums, k));
    }
}
