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
public class ReverseLinkedListTest {
    @Test
    public void test() {
        ReverseLinkedList test = new ReverseLinkedList();
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4, 5);
        assertEquals("5,4,3,2,1", LinkedListUtils.serialize(test.reverseList(head)));
    }

    @Test
    public void test2() {
        ReverseLinkedList test = new ReverseLinkedList();
        ListNode head = LinkedListUtils.constructLinkedList(1);
        assertEquals("1", LinkedListUtils.serialize(test.reverseList(head)));
    }

    @Test
    public void test3() {
        ReverseLinkedList test = new ReverseLinkedList();
        ListNode head = LinkedListUtils.constructLinkedList(1, 2);
        assertEquals("2,1", LinkedListUtils.serialize(test.reverseList(head)));
    }

    @Test
    public void test4() {
        ReverseLinkedList test = new ReverseLinkedList();
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4);
        assertEquals("4,3,2,1", LinkedListUtils.serialize(test.reverseList2(head)));
    }
}
