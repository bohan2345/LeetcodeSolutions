package utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 1/27/2016.
 *
 * @author Bohan Zheng
 */
public class LinkedListUtilsTest {
    @Test
    public void testConstruct() {
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3);
        assertEquals(head.val, 1);
        assertEquals(head.next.val, 2);
        assertEquals(head.next.next.val, 3);
        assertEquals(head.next.next.next, null);
    }

    @Test
    public void testSerialize() {
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3);
        assertEquals("1,2,3", LinkedListUtils.serialize(head));
    }
}
