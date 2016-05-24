package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation
 * which turns the water at position (row, col) into a land. Given a list of positions to operate, count the
 * number of islands after each addLand operation. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example:
 * <p>
 * Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 * <p>
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * <p>
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * <p>
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * <p>
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * <p>
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 * We return the result as an array: [1, 1, 2, 3]
 * <p>
 * Created by Bohan Zheng on 5/23/2016.
 *
 * @author Bohan Zheng
 */
public class NumberofIslandsII {
    private class DisjointSet {
        int[][] positions;

        DisjointSet(int m, int n) {
            positions = new int[m][n];
            int counter = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    positions[i][j] = counter++;
                }
            }
        }

        void union(int ai, int aj, int bi, int bj) {
            int tmp = positions[ai][aj];
            for (int i = 0; i < positions.length; i++) {
                for (int j = 0; j < positions[i].length; j++) {
                    if (positions[i][j] == tmp) {
                        positions[i][j] = positions[bi][bj];
                    }
                }
            }
        }

        boolean find(int ai, int aj, int bi, int bj) {
            return positions[ai][aj] == positions[bi][bj];
        }
    }

    public List<Integer> numIslands2(int m, int n, List<Position> positions) {
        DisjointSet ds = new DisjointSet(m, n);
        Set<Position> grid = new HashSet<>(positions.size());
        int numIslands = 0;
        List<Integer> res = new ArrayList<>(positions.size());
        for (Position position : positions) {
            int x = position.x, y = position.y;
            grid.add(position);
            numIslands++;
            Position up = new Position(x - 1, y);
            Position bottom = new Position(x + 1, y);
            Position left = new Position(x, y - 1);
            Position right = new Position(x, y + 1);
            if (grid.contains(up)) {
                ds.union(up.x, up.y, position.x, position.y);
                numIslands--;
            }
            if (grid.contains(bottom)) {
                ds.union(bottom.x, bottom.y, position.x, position.y);
                numIslands--;
            }
            if (grid.contains(left)) {
                ds.union(left.x, left.y, position.x, position.y);
                numIslands--;
            }
            if (grid.contains(right)) {
                ds.union(right.x, right.y, position.x, position.y);
                numIslands--;
            }
            res.add(numIslands);
        }
        return res;
    }

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            return x == position.x && y == position.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
