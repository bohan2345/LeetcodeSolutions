package google;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * <p>
 * Created by Bohan Zheng on 7/4/16.
 *
 * @author Bohan Zheng
 */
public class GameofGoTest {
    @Test
    public void test() {
        GameofGo test = new GameofGo();
        int board[][] = {
                {1, 1, 1, 1},
                {1, 2, 2, 1},
                {2, 2, 2, 1},
                {1, 1, 1, 1}};
        assertFalse(test.isSurranded(board, 1, 1));
    }
}