package google;

/**
 * <p>
 * Created by Bohan Zheng on 7/10/16.
 *
 * @author Bohan Zheng
 */
public class WallsandGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null) {
            return;
        }
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    bfsHelper(rooms, i, j, 0);
                }
            }
        }
    }

    public void bfsHelper(int[][] rooms, int i, int j, int distance) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) {
            return;
        }
        if (rooms[i][j] == -1) {
            return;
        }
        if (distance != 0 && distance >= rooms[i][j]) {
            return;
        }
        rooms[i][j] = distance;
        bfsHelper(rooms, i + 1, j, distance + 1);
        bfsHelper(rooms, i - 1, j, distance + 1);
        bfsHelper(rooms, i, j + 1, distance + 1);
        bfsHelper(rooms, i, j - 1, distance + 1);
    }
}
