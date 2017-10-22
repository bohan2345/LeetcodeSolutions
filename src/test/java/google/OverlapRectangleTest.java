package google;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class OverlapRectangleTest {
    @Test
    public void test() {
        OverlapRectangle test = new OverlapRectangle();
        OverlapRectangle.Rectangle rectangle1 = new OverlapRectangle.Rectangle(1, 3, 1, 3);
        OverlapRectangle.Rectangle rectangle2 = new OverlapRectangle.Rectangle(2, 4, 2, 4);
        OverlapRectangle.Rectangle rectangle3 = new OverlapRectangle.Rectangle(4, 6, 1, 3);
        OverlapRectangle.Rectangle[] rectangles = {rectangle1, rectangle2, rectangle3};

        int count = test.maxNumberOfOverlappingRectangle(rectangles);

        assertThat(count).isEqualTo(2);
    }

    @Test
    public void test2() {
        OverlapRectangle test = new OverlapRectangle();
        OverlapRectangle.Rectangle rectangle1 = new OverlapRectangle.Rectangle(1, 3, 1, 3);
        OverlapRectangle.Rectangle rectangle2 = new OverlapRectangle.Rectangle(2, 8, 1, 2);
        OverlapRectangle.Rectangle rectangle3 = new OverlapRectangle.Rectangle(4, 6, 4, 6);
        OverlapRectangle.Rectangle rectangle4 = new OverlapRectangle.Rectangle(6, 8, 6, 8);
        OverlapRectangle.Rectangle[] rectangles = {rectangle1, rectangle2, rectangle3, rectangle4};

        int count = test.maxNumberOfOverlappingRectangle(rectangles);

        assertThat(count).isEqualTo(2);
    }
}
