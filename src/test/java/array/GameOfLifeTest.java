package array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * <p>
 * Created by Bohan Zheng on 11/16/2015.
 *
 * @author Bohan Zheng
 */
public class GameOfLifeTest {
    GameOfLife test = new GameOfLife();

    @Test
    public void test() {
        int[][] board = {{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        test.gameOfLife(board);
        assertArrayEquals(board, board);
    }

    @Test
    public void test2() {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int[][] expected = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
        test.gameOfLife(board);
        assertArrayEquals(expected, board);
    }

    @Test
    public void test3() {
        int[][] expected = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
        test.gameOfLife(board);
        assertArrayEquals(expected, board);
    }
}
