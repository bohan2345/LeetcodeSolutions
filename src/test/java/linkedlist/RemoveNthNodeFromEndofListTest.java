package linkedlist;

import org.junit.Test;
import utils.LinkedListUtils;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 2/9/2016.
 *
 * @author Bohan Zheng
 */
public class RemoveNthNodeFromEndofListTest {
    @Test
    public void test() {
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3);
        RemoveNthNodeFromEndofList test = new RemoveNthNodeFromEndofList();
        assertEquals("2,3", LinkedListUtils.serialize(test.removeNthFromEnd(head, 3)));
    }

    @Test
    public void test2() {
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3);
        RemoveNthNodeFromEndofList test = new RemoveNthNodeFromEndofList();
        assertEquals("1,2", LinkedListUtils.serialize(test.removeNthFromEnd(head, 1)));
    }

    @Test
    public void test3() {
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4);
        RemoveNthNodeFromEndofList test = new RemoveNthNodeFromEndofList();
        assertEquals("1,3,4", LinkedListUtils.serialize(test.removeNthFromEnd(head, 3)));
    }
}
