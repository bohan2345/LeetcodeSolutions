package array;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules
 * (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.<br>
 * Any live cell with two or three live neighbors lives on to the next generation.<br>
 * Any live cell with more than three live neighbors dies, as if by over-population.<br>
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.<br>
 * Write a function to compute the next state (after one update) of the board given its current state.
 * <p>
 * Follow up:
 * Could you solve it in-place? Remember that the board needs to be updated at the same time:
 * You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite,
 * which would cause problems when the active area encroaches the border of the array.
 * How would you address these problems?
 * <p>
 * Created by Bohan Zheng on 11/16/2015.
 *
 * @author Bohan Zheng
 */
public class GameOfLife {
    /**
     * 这道题是有名的康威生命游戏, 而我又是第一次听说这个东东，这是一种细胞自动机，
     * 每一个位置有两种状态，1为活细胞，0为死细胞，对于每个位置都满足如下的条件：
     * <p>
     * 1. 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡
     * <p>
     * 2. 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活
     * <p>
     * 3. 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡
     * <p>
     * 4. 如果死细胞周围正好有三个活细胞，则该位置死细胞复活
     * <p>
     * 由于题目中要求我们用置换方法in-place来解题，所以我们就不能新建一个相同大小的数组，
     * 那么我们只能更新原有数组，但是题目中要求所有的位置必须被同时更新，但是在循环程序中
     * 我们还是一个位置一个位置更新的，那么当一个位置更新了，这个位置成为其他位置的neighbor时
     * ，我们怎么知道其未更新的状态呢，我们可以使用状态机转换：
     * <p>
     * 状态0： 死细胞转为死细胞
     * <p>
     * 状态1： 活细胞转为活细胞
     * <p>
     * 状态2： 活细胞转为死细胞
     * <p>
     * 状态3： 死细胞转为活细胞
     * <p>
     * 最后我们对所有状态对2取余，那么状态0和2就变成死细胞，状态1和3就是活细胞，达成目的。
     * 我们先对原数组进行逐个扫描，对于每一个位置，扫描其周围八个位置，如果遇到状态1或2，
     * 就计数器累加1，扫完8个邻居，如果少于两个活细胞或者大于三个活细胞，而且当前位置是活细胞的话，
     * 标记状态2，如果正好有三个活细胞且当前是死细胞的话，标记状态3。完成一遍扫描后再对数据扫描一遍
     * ，对2取余变成我们想要的结果。参见代码如下：
     */
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j);
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 2;
                } else if (liveNeighbors == 3 && board[i][j] == 0) {
                    board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] %= 2;
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int i, int j) {
        int count = 0;
        int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int k = 0; k < 8; ++k) {
            if (i + di[k] >= 0 && i + di[k] < board.length && j + dj[k] >= 0 && j + dj[k] < board[0].length)
                if (board[i + di[k]][j + dj[k]] == 1 || board[i + di[k]][j + dj[k]] == 2) {
                    count++;
                }
        }
        return count;
    }
}
