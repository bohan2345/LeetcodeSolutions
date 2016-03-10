package hashtable;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 3/9/2016.
 *
 * @author Bohan Zheng
 */
public class SudokuSolverTest {
            //["519748632","783652419","426139875","357986241","264317598","198524367","975863124","832491756","641275983"]
    @Test
    public void test() {
        char[][] board = {
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}};
        SudokuSolver test = new SudokuSolver();
        test.solveSudoku(board);
        //["519748632","783652419","426139875","357986241","264317598","198524367","975863124","832491756","641275983"]
        assertArrayEquals(new char[]{'5','1','9','7','4','8','6','3','2'}, board[0]);
    }
}
