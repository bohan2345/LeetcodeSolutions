package array;

import array.WordSearch;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <br>
 * Created by Bohan Zheng on 9/4/2015.
 *
 * @author Bohan Zheng
 */
public class WordSearchTest {
    WordSearch test = new WordSearch();

    @Test
    public void test() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        assertTrue(test.exist(board, "ABCCED"));
    }

    @Test
    public void test2() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        assertFalse(test.exist(board, "ABCB"));
    }

    @Test
    public void test3() {
        char[][] board = {{'A', 'B'}, {'C', 'D'}};
        assertTrue(test.exist(board, "CDBA"));
    }
}
