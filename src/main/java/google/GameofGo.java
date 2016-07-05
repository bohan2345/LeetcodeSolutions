package google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * Created by Bohan Zheng on 7/4/16.
 *
 * @author Bohan Zheng
 */
public class GameofGo {
    //board[][] 0 -> empty, 1 -> white, 2 -> black
    public boolean isSurranded(int[][] board, int x, int y) {
        return bfs(board, new Piece(board[x][y], x, y));
    }

    boolean bfs(int[][] board, Piece startP) {
        Queue<Piece> q = new LinkedList<>();
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        q.offer(startP);
        int value = startP.value == 1 ? 2 : 1;
        while (!q.isEmpty()) {
            Piece p = q.poll();
            if (!visited[p.x][p.y + 1] && board[p.x][p.y + 1] != value) {
                if (p.y + 1 == n || p.value == 0) return false;
                visited[p.x][p.y + 1] = true;
                q.offer(new Piece(board[p.x][p.y + 1], p.x, p.y + 1));
            }

            if (!visited[p.x][p.y - 1] && board[p.x][p.y - 1] != value) {
                if (p.y - 1 == 0 || p.value == 0) return false;
                visited[p.x][p.y - 1] = true;
                q.offer(new Piece(board[p.x][p.y - 1], p.x, p.y - 1));
            }

            if (!visited[p.x + 1][p.y] && board[p.x + 1][p.y] != value) {
                if (p.x + 1 == m || p.value == 0) return false;
                visited[p.x + 1][p.y] = true;
                q.offer(new Piece(board[p.x + 1][p.y], p.x + 1, p.y));
            }

            if (!visited[p.x - 1][p.y + 1] && board[p.x - 1][p.y] != value) {
                if (p.x - 1 == 0 || p.value == 0) return false;
                visited[p.x - 1][p.y + 1] = true;
                q.offer(new Piece(board[p.x - 1][p.y], p.x - 1, p.y));
            }

        }
        return true;
    }

    private class Piece {
        int value;
        int x;
        int y;

        private Piece(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }
}
