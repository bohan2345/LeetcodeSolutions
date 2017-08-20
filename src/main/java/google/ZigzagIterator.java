package google;

import java.util.ArrayList;
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
            count--;
            res = next();
        }
        count++;
        return res;
    }


    public static class ZigzagIteratorII {
        private List<Iterator<Integer>> list;
        private int i = 0;

        public ZigzagIteratorII(List<Integer> v1, List<Integer> v2) {
            list = new ArrayList<>();
            Iterator<Integer> i1 = v1.iterator();
            Iterator<Integer> i2 = v2.iterator();
            if (i1.hasNext()) list.add(i1);
            if (i2.hasNext()) list.add(i2);
        }

        public int next() {
            if (!hasNext()) {
                return 0;
            }
            Iterator<Integer> x = list.get(i);
            int res = x.next();
            if (!x.hasNext()) {
                list.remove(x);
                i--;
            }
            if (i < list.size() - 1) {
                i++;
            } else {
                i = 0;
            }

            return res;
        }

        public boolean hasNext() {
            return list.size() > 0;
        }
    }
}

