package google;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class CompareStringsWithDelTest {
    @Test
    public void test() {
        CompareStringsWithDel test = new CompareStringsWithDel();
        String a = "abc#a##";
        String b = "a";

        assertThat(test.compareStrings(a, b)).isTrue();
    }

    @Test
    public void test2() {
        CompareStringsWithDel test = new CompareStringsWithDel();
        String a = "abc###def";
        String b = "def";

        assertThat(test.compareStrings(a, b)).isTrue();
    }
}
