package linkedlist;

import org.junit.Test;
import utils.LinkedListUtils;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 2/11/16.
 *
 * @author Bohan Zheng
 */
public class LinkedListCycleIITest {
    @Test
    public void test() {
        LinkedListCycleII test = new LinkedListCycleII();
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4, 5);
        ListNode n3 = head.next.next;
        n3.next.next = n3;
        assertEquals(n3, test.detectCycle(head));
    }
}