package string;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class DecodeWaysIITest {
    DecodeWaysII test = new DecodeWaysII();

    @Test
    public void test() {
        assertThat(test.numDecodings("*")).isEqualTo(9);
    }

    @Test
    public void test2() {
        assertThat(test.numDecodings("1*")).isEqualTo(18);
    }

    @Test
    public void test3() {
        assertThat(test.numDecodings("11**")).isEqualTo(273);
    }

    @Test
    public void test4() {
        assertThat(test.numDecodings("*1*1*0")).isEqualTo(404);
    }

    @Test
    public void test5() {
        assertThat(test.numDecodings("**********1111111111")).isEqualTo(133236775);
    }
}
