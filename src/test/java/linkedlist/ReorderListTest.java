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
public class ReorderListTest {
    @Test
    public void test() {
        ReorderList test = new ReorderList();
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4, 5);
        test.reorderList(head);
        assertEquals("1,5,2,4,3", LinkedListUtils.serialize(head));
    }
}
