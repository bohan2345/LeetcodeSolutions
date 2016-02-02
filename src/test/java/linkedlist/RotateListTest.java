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
public class RotateListTest {
    @Test
    public void test() {
        RotateList test = new RotateList();
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4, 5);
        assertEquals("4,5,1,2,3", LinkedListUtils.serialize(test.rotateRight(head, 2)));
    }

    @Test
    public void test2() {
        RotateList test = new RotateList();
        ListNode head = LinkedListUtils.constructLinkedList(1);
        assertEquals("1", LinkedListUtils.serialize(test.rotateRight(head, 0)));
    }
}
