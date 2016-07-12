package google;

/**
 * <p>
 * Created by Bohan Zheng on 7/11/16.
 *
 * @author Bohan Zheng
 */
public class TicTacToe {
    private int[] cols;
    private int[] rows;
    private int diagonal;
    private int antidiagonal;
    private int n;

    public TicTacToe(int n) {
        cols = new int[n];
        rows = new int[n];
        this.n = n;
    }

    /**
     * @param row
     * @param col
     * @param player 1 or 2
     * @return 0: no one wins, 1: 1 wins, 2: 2 wins
     */
    public int move(int row, int col, int player) {
        int addon = player == 1 ? 1 : -1;
        cols[col] += addon;
        rows[row] += addon;
        if (row == col) diagonal += addon;
        if (row + col == n - 1) antidiagonal += addon;
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(antidiagonal) == n || Math.abs(diagonal) == n) {
            return player;
        } else {
            return 0;
        }
    }

    public static void main(String[] strs) {
        TicTacToe x = new TicTacToe(2);
        System.out.println(x.move(0,0,2));
        System.out.println(x.move(1,1,1));
        System.out.println(x.move(0,1,2));
    }
}
