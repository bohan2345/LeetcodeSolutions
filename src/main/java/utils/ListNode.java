package utils;

/**
 * <p>
 * Created by Bohan Zheng on 1/26/2016.
 *
 * @author Bohan Zheng
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
}
