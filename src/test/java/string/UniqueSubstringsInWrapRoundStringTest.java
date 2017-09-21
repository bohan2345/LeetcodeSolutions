package string;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class UniqueSubstringsInWrapRoundStringTest {
    @Test
    public void test() {
        UniqueSubstringsInWrapRoundString test = new UniqueSubstringsInWrapRoundString();
        assertThat(test.findSubstringInWraproundString("zab")).isEqualTo(6);
    }

    @Test
    public void test2() {
        UniqueSubstringsInWrapRoundString test = new UniqueSubstringsInWrapRoundString();
        assertThat(test.findSubstringInWraproundString("cac")).isEqualTo(2);
    }
}
