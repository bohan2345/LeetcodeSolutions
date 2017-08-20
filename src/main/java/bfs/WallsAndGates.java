package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public void wallsAndGates(int[][] rooms) {
        for (int x = 0; x < rooms.length; x++) {
            for (int y = 0; y < rooms[x].length; y++) {
                if (rooms[x][y] == 0) {
                    searchPathDistance(rooms, x, y);
                }
            }
        }
    }

    private void searchPathDistance(int[][] rooms, int x, int y) {
        int distance = 1;
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        int current = 1;
        int next = 0;
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Coordinate c = queue.poll();
            current--;
            rooms[c.x][c.y] = Math.min(rooms[c.x][c.y], distance);
            visited[c.x][c.y] = true;
            for (int i = 0; i < 4; i++) {
                int x2 = c.x + dx[i];
                int y2 = c.y + dy[i];
                if (x2 >= 0 && y2 >= 0 &&
                        x2 < rooms.length &&
                        y2 < rooms[0].length &&
                        rooms[x2][y2] != -1 &&
                        rooms[x2][y2] != 0 &&
                        !visited[x2][y2]) {
                    queue.offer(new Coordinate(x2, y2));
                    next++;
                }
            }
            if (current == 0) {
                current = next;
                next = 0;
                distance++;
            }
        }
    }

    private class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
