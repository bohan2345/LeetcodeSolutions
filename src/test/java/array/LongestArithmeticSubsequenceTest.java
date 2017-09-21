package array;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class LongestArithmeticSubsequenceTest {
    private LongestArithmeticSubsequence test;

    @Before
    public void setup() {
        test = new LongestArithmeticSubsequence();
    }

    @Test
    public void test() {
        int[] array = {2, 4, 6, 8, 10};
        assertThat(test.lenghtOfLongestAP(array)).isEqualTo(5);
    }

    @Test
    public void test2() {
        int[] array = {1, 2, 4, 5, 6, 8, 22};
        assertThat(test.lenghtOfLongestAP(array)).isEqualTo(4);
    }

    @Test
    public void test3() {
        int[] array = {1, Integer.MAX_VALUE / 2 + 1, Integer.MAX_VALUE};
        assertThat(test.lenghtOfLongestAP(array)).isEqualTo(3);
    }
}
