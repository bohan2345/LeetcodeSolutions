package linkedlist;

import org.junit.Test;
import utils.LinkedListUtils;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 2/16/2016.
 *
 * @author Bohan Zheng
 */
public class InsertionSortListTest {
    @Test
    public void test() {
        InsertionSortList test = new InsertionSortList();
        ListNode head = LinkedListUtils.constructLinkedList(5, 4, 3, 2, 1);
        assertEquals("1,2,3,4,5", LinkedListUtils.serialize(test.insertionSortList(head)));
    }

    @Test
    public void test2() {
        InsertionSortList test = new InsertionSortList();
        ListNode head = LinkedListUtils.constructLinkedList(1);
        assertEquals("1", LinkedListUtils.serialize(test.insertionSortList(head)));
    }

    @Test
    public void test3() {
        InsertionSortList test = new InsertionSortList();
        ListNode head = LinkedListUtils.constructLinkedList(1, 2);
        assertEquals("1,2", LinkedListUtils.serialize(test.insertionSortList(head)));
    }
}
