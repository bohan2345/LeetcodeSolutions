package google;

import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 * Created by Bohan Zheng on 6/28/2016.
 *
 * @author Bohan Zheng
 */
public class SuperMatrix {
    TreeMap<Long, MatrixRow> matrix;

    public SuperMatrix() {
        matrix = new TreeMap<>();
    }

    public void addValue(long x, long y, int value) {
        MatrixPoint point = new MatrixPoint(x, y, value);
        if (matrix.containsKey(y)) {
            matrix.get(y).addPoint(point);
        } else {
            MatrixRow row = new MatrixRow(y);
            row.addPoint(point);
            matrix.put(y, row);
        }
    }

    public long getSum(long x1, long y1, long x2, long y2) {
        long sum = 0;
        if (y1 > y2) {
            long tmp = y1;
            y1 = y2;
            y2 = tmp;
        }
        if (x1 > x2) {
            long tmp = x1;
            x1 = x2;
            x2 = tmp;
        }
        Map.Entry<Long, MatrixRow> y = matrix.ceilingEntry(y1);

        while (y != null && y.getKey() <= y2) {
            sum += y.getValue().getSum(x1, x2);
            y = matrix.higherEntry(y.getKey());
        }
        return sum;
    }

    private class MatrixRow {
        TreeMap<Long, MatrixPoint> row;
        long rowNum;

        MatrixRow(long rowNum) {
            this.row = new TreeMap<>();
            this.rowNum = rowNum;
        }

        void addPoint(MatrixPoint point) {
            row.put(point.x, point);
        }

        long getSum(long x1, long x2) {
            long sum = 0;
            Map.Entry<Long, MatrixPoint> x = row.ceilingEntry(x1);
            while (x.getKey() < x2) {
                sum += x.getValue().value;
                x = row.higherEntry(x.getKey());
            }
            return sum;
        }
    }

    private class MatrixPoint {
        long x;
        long y;
        int value;

        MatrixPoint(long x, long y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
