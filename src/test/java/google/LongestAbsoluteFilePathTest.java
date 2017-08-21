package google;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class LongestAbsoluteFilePathTest {
    @Test
    public void test() {
        LongestAbsoluteFilePath test = new LongestAbsoluteFilePath();
        int length = test.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
        assertThat(length).isEqualTo(20);
    }

    @Test
    public void test2() {
        LongestAbsoluteFilePath test = new LongestAbsoluteFilePath();
        int length = test.lengthLongestPath("dir\n        file.txt");
        assertThat(length).isEqualTo(16);
    }
}
