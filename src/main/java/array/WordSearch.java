package array;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * <p>
 * For example, Given board =<p>
 * [<br>
 * ["ABCE"],<br>
 * ["SFCS"],<br>
 * ["ADEE"]<br>
 * ]<br>
 * word = "ABCCED", -> returns true,<br>
 * word = "SEE", -> returns true,<br>
 * word = "ABCB", -> returns false.<br>
 * <br>
 * Created by Bohan Zheng on 9/4/2015.
 *
 * @author Bohan Zheng
 */
public class WordSearch {
  public boolean exist(char[][] board, String word) {
    boolean[][] used = new boolean[board.length][board[0].length];
    for (int x = 0; x < board.length; x++) {
      for (int y = 0; y < board[x].length; y++) {
        if (board[x][y] == word.charAt(0) && dfsHelper(board, word, 0, x, y, used)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfsHelper(char[][] board, String word, int i, int x, int y, boolean[][] used) {
    if (i == word.length()) {
      return true;
    }
    if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || used[x][y]) {
      return false;
    }
    char c = word.charAt(i);
    if (c != board[x][y]) {
      return false;
    }
    used[x][y] = true;
    boolean top = dfsHelper(board, word, i + 1, x - 1, y, used);
    if (top) return true;
    boolean down = dfsHelper(board, word, i + 1, x + 1, y, used);
    if (down) return true;
    boolean left = dfsHelper(board, word, i + 1, x, y - 1, used);
    if (left) return true;
    boolean right = dfsHelper(board, word, i + 1, x, y + 1, used);
    used[x][y] = false;
    return right;
  }
}
