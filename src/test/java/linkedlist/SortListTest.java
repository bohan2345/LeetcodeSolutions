package linkedlist;

import org.junit.Test;
import utils.LinkedListUtils;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 2/2/2016.
 *
 * @author Bohan Zheng
 */
public class SortListTest {
    @Test
    public void test() {
        SortList test = new SortList();
        ListNode head = LinkedListUtils.constructLinkedList(2, 1);
        assertEquals("1,2", LinkedListUtils.serialize(test.sortList(head)));
    }

    @Test
    public void test2() {
        SortList test = new SortList();
        ListNode head = LinkedListUtils.constructLinkedList(5, 4, 3, 2, 1);
        assertEquals("1,2,3,4,5", LinkedListUtils.serialize(test.sortList(head)));
    }
}
