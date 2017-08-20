package backtrack;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class AndroidUnlockPatternsTest {
    private AndroidUnlockPatterns test;

    @Before
    public void setup() {
        test = new AndroidUnlockPatterns();
    }

    @Test
    public void test() {
        int n = test.numberOfPatterns(1, 1);
        assertThat(n).isEqualTo(9);
    }

    @Test
    public void test2() {
        int n = test.numberOfPatterns(2, 2);
        assertThat(n).isEqualTo(56);
    }

    @Test
    public void test3() {
        int n = test.numberOfPatterns(1, 4);
        assertThat(n).isEqualTo(2009);
    }
}
