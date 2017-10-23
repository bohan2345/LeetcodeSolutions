package google;

import utils.Rectangle;

import java.util.Arrays;
import java.util.Random;

public class RandomPoint {
    private int[] weights;
    private Rectangle[] rec;

    RandomPoint(Rectangle[] rec) {
        this.rec = rec;
        int[] area = new int[rec.length];
        for (int i = 0; i < rec.length; i++) {
            area[i] = getArea(rec[i]);
        }

        this.weights = new int[area.length];
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += area[i];
            weights[i] = sum;
        }
    }

    public int[] randomPickInRectangles() {
        Random rand = new Random();
        int tmp = rand.nextInt(weights[weights.length - 1] + 1);
        int pos = Arrays.binarySearch(weights, 0, weights.length, tmp);
        if (pos < 0) {
            pos = -(pos + 1);
        }

        return getRandomPointInRec(rec[pos]);
    }

    private int getArea(Rectangle rec) {
        return (rec.x2 - rec.x1) * (rec.y2 - rec.y1);
    }

    private int[] getRandomPointInRec(Rectangle rec) {
        Random rand = new Random();
        int xRandom = rand.nextInt(rec.x2 - rec.x1 + 1) + rec.x1;
        int yRandom = rand.nextInt(rec.y2 - rec.y1 + 1) + rec.y1;
        return new int[]{xRandom, yRandom};
    }
}
