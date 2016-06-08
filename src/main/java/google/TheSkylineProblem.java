package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>
 * Created by Bohan Zheng on 6/7/2016.
 *
 * @author Bohan Zheng
 */
public class TheSkylineProblem {
    private class Wall {
        private int x;
        private boolean isLeft;
        private int height;

        private Wall(int x, boolean isLeft, int height) {
            this.x = x;
            this.isLeft = isLeft;
            this.height = height;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2.compareTo(i1));
        List<Wall> walls = new ArrayList<>(buildings.length * 2);
        for (int[] building : buildings) {
            walls.add(new Wall(building[0], true, building[2]));
            walls.add(new Wall(building[1], false, building[2]));
        }
        Collections.sort(walls, (o1, o2) -> new Integer(o1.x).compareTo(o2.x));
        List<int[]> res = new ArrayList<>();
        queue.offer(0);
        for (Wall wall : walls) {
            if (wall.isLeft) {
                if (wall.height > queue.peek())
                    res.add(new int[]{wall.x, wall.height});
                queue.offer(wall.height);
            } else {
                queue.remove(wall.height);
                if (queue.peek() < wall.height)
                    res.add(new int[]{wall.x, queue.peek()});
            }
        }
        return res;
    }
}
