package google;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 5/18/2016.
 *
 * @author Bohan Zheng
 */
public class FilpGameIITest {
    @Test
    public void test() {
        FilpGameII test = new FilpGameII();
        assertTrue(test.canWin("++++"));
    }
    @Test
    public void test2() {
        FilpGameII test = new FilpGameII();
        assertTrue(test.canWin2("++++"));
    }
}
