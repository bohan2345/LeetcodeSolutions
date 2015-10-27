package test.array;

import main.array.MissingNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 10/27/2015.
 *
 * @author Bohan Zheng
 */
public class MissingNumberTest {
    MissingNumber test = new MissingNumber();

    @Test
    public void test() {
        int actural = test.missingNumber(new int[]{4, 0, 1, 2});
        assertEquals(3, actural);
    }
}
