package google;

import utils.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OverlapRectangle {


    class Node {
        int index;
        boolean isLeft;

        Node(int index, boolean isLeft) {
            this.index = index;
            this.isLeft = isLeft;
        }
    }

    public int maxNumberOfOverlappingRectangle(Rectangle[] rectangles) {
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a.x2));

        int maxCount = 0;
        for (int i = 0; i < rectangles.length; i++) {
            Rectangle cur = rectangles[i];
            List<Rectangle> list = getHorizontalOverlapping(rectangles, cur, i);
            maxCount = Math.max(maxCount, getVerticalOverLapping(list));
        }
        return maxCount;
    }

    private List<Rectangle> getHorizontalOverlapping(Rectangle[] rectangles, Rectangle cur, int index) {
        List<Rectangle> list = new ArrayList<>();

        for (int i = index + 1; i < rectangles.length; i++) {
            if (cur.x2 > rectangles[i].x1) {
                list.add(rectangles[i]);
            }
        }
        list.add(cur);
        return list;
    }

    private int getVerticalOverLapping(List<Rectangle> rectangles) {
        List<Node> list = new ArrayList<>();
        for (Rectangle r : rectangles) {
            Node left = new Node(r.y1, true);
            Node right = new Node(r.y2, false);

            list.add(left);
            list.add(right);
        }

        list.sort((a, b) -> {
            if (a.index != b.index) {
                return a.index - b.index;
            } else {
                return !a.isLeft && b.isLeft ? 1 : -1;
            }
        });

        int count = 0;
        int maxCount = 0;
        for (Node n : list) {
            if (n.isLeft) {
                count++;
            } else {
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}