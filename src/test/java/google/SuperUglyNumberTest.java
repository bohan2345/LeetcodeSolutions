package google;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class SuperUglyNumberTest {
    private SuperUglyNumber test = new SuperUglyNumber();

    @Test
    public void test() {
        int[] primes = {2, 7, 13, 19};

        int uglyNum = test.nthSuperUglyNumber(12, primes);

        assertThat(uglyNum).isEqualTo(32);
    }
}
