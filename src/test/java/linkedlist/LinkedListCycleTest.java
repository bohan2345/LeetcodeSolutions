package linkedlist;

import org.junit.Test;
import utils.LinkedListUtils;
import utils.ListNode;

import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 2/11/16.
 *
 * @author Bohan Zheng
 */
public class LinkedListCycleTest {
    @Test
    public void test() {
        LinkedListCycle test = new LinkedListCycle();
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4, 5);
        ListNode n3 = head.next.next;
        n3.next.next = n3;
        assertTrue(test.hasCycle(head));
    }
}
