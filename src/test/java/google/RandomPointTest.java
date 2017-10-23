package google;

import org.junit.Test;
import utils.Rectangle;

public class RandomPointTest {
    @Test
    public void test() {
        Rectangle rectangle1 = new Rectangle(0, 1, 0, 1);
        Rectangle rectangle2 = new Rectangle(5, 6, 0, 1);
        Rectangle rectangle3 = new Rectangle(7, 8, 0, 1);
        Rectangle[] rectangles = {rectangle1, rectangle2, rectangle3};
        RandomPoint test = new RandomPoint(rectangles);
        int[] point = test.randomPickInRectangles();
    }
}
