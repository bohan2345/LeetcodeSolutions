package google;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class SmallestRectangleEnclosingBlackPixelsTest {
    private SmallestRectangleEnclosingBlackPixels test = new SmallestRectangleEnclosingBlackPixels();

    @Test
    public void test() {
        // "0010",
        // "0110",
        // "0100"
        char[][] image = {{'0', '0', '1', '0'}, {'0', '1', '1', '0'}, {'0', '1', '1', '0'}};

        int res = test.minArea(image, 0, 2);

        assertThat(res).isEqualTo(6);
    }
}
