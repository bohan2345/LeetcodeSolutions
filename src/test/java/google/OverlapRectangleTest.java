package google;

import org.junit.Test;
import utils.Rectangle;

import static com.google.common.truth.Truth.assertThat;

public class OverlapRectangleTest {
    @Test
    public void test() {
        OverlapRectangle test = new OverlapRectangle();
        Rectangle rectangle1 = new Rectangle(1, 3, 1, 3);
        Rectangle rectangle2 = new Rectangle(2, 4, 2, 4);
        Rectangle rectangle3 = new Rectangle(4, 6, 1, 3);
        Rectangle[] rectangles = {rectangle1, rectangle2, rectangle3};

        int count = test.maxNumberOfOverlappingRectangle(rectangles);

        assertThat(count).isEqualTo(2);
    }

    @Test
    public void test2() {
        OverlapRectangle test = new OverlapRectangle();
        Rectangle rectangle1 = new Rectangle(1, 3, 1, 3);
        Rectangle rectangle2 = new Rectangle(2, 8, 1, 2);
        Rectangle rectangle3 = new Rectangle(4, 6, 4, 6);
        Rectangle rectangle4 = new Rectangle(6, 8, 6, 8);
        Rectangle[] rectangles = {rectangle1, rectangle2, rectangle3, rectangle4};

        int count = test.maxNumberOfOverlappingRectangle(rectangles);

        assertThat(count).isEqualTo(2);
    }
}
