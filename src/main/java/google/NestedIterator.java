package google;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * <p>
 * Created by Bohan Zheng on 7/4/16.
 *
 * @author Bohan Zheng
 */
public class NestedIterator implements Iterator<Integer> {
    private Stack<Iterator<NestedInteger>> itStack;
    private Integer next;

    public NestedIterator(List<NestedInteger> nestedList) {
        itStack = new Stack<>();
        itStack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }

        Integer result = next;
        next = null;
        return result;
    }

    @Override
    public boolean hasNext() {
        if(next != null) {
            return true;
        }

        while(!itStack.isEmpty()) {
            Iterator<NestedInteger> it = itStack.peek();
            if(!it.hasNext()) {
                itStack.pop();
            } else {
                NestedInteger ni = it.next();
                if(ni.isInteger()) {
                    next = ni.getInteger();
                    return true;
                } else {
                    itStack.push(ni.getList().iterator());
                }
            }
        }
        return false;
    }

    public static class NestedInteger {
        private int value;
        private List<NestedInteger> list;

        public NestedInteger(int value){
            this.value = value;
        }
        public NestedInteger(List<NestedInteger> list){
            this.list = list;
        }
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return list == null;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return this.value;
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return this.list;
        }
    }

}