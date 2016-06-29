package google;

import java.util.Iterator;
import java.util.List;


/**
 * <p>
 * Created by Bohan Zheng on 6/28/2016.
 *
 * @author Bohan Zheng
 */
public class ZigzagIterator<T> implements Iterator<T> {
    private List<T[]> A;
    private int size;
    private int count;
    private int i;
    private int j;

    public ZigzagIterator(List<T[]> A) {
        this.A = A;
        int size = 0;
        for (int i = 0; i < A.size(); i++) {
            size += A.get(i).length;
        }
        this.size = size;
        this.count = 0;
        this.i = 0;
        this.j = 0;
    }

    @Override
    public boolean hasNext() {
        return count < size;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }
        T[] array = A.get(i);
        T res;
        if (j < array.length) {
            res = array[j];
            if (i < A.size() - 1) {
                i++;
            } else {
                i = 0;
                j++;
            }
        } else {
            if (i < A.size() - 1) {
                i++;
            } else {
                i = 0;
                j++;
            }
            res = next();
        }
        count++;
        return res;
    }
}
