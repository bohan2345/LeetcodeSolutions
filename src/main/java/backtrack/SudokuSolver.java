package backtrack;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * <p>
 * Created by Bohan Zheng on 3/9/2016.
 *
 * @author Bohan Zheng
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board, 0, 0);
    }

    private boolean solveSudokuHelper(char[][] board, int i, int j) {
        if (j > 8) {
            j = 0;
            i++;
        }
        if (i > 8) {
            return true;
        }
        if (board[i][j] == '.') {
            for (char n = '1'; n <= '9'; n++) {
                if (!isValid(board, i, j, n)) {
                    continue;
                }
                board[i][j] = n;
                if (solveSudokuHelper(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
            }
            return false;
        } else {
            return solveSudokuHelper(board, i, j + 1);
        }
    }

    private boolean isValid(char[][] board, int i, int j, char n) {
        boolean isValid = true;
        for (int x = 0; x < 9; x++) {
            isValid = isValid && board[i][x] != n;
            isValid = isValid && board[x][j] != n;
        }
        for (int x = (i / 3) * 3; x < (i / 3) * 3 + 3; x++) {
            for (int y = (j / 3) * 3; y < (j / 3) * 3 + 3; y++) {
                isValid = isValid && board[x][y] != n;
            }
        }
        return isValid;
    }
}
