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
public class ReverseLinkedListIITest {
    @Test
    public void test() {
        ReverseLinkedListII test = new ReverseLinkedListII();
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4, 5);
        assertEquals("1,4,3,2,5", LinkedListUtils.serialize(test.reverseBetween(head, 2, 4)));
    }

    @Test
    public void test2() {
        ReverseLinkedListII test = new ReverseLinkedListII();
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4, 5);
        assertEquals("5,4,3,2,1", LinkedListUtils.serialize(test.reverseBetween(head, 1, 5)));
    }

    @Test
    public void test3() {
        ReverseLinkedListII test = new ReverseLinkedListII();
        ListNode head = LinkedListUtils.constructLinkedList(1);
        assertEquals("1", LinkedListUtils.serialize(test.reverseBetween(head, 1, 1)));
    }
}
