package linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;
import utils.LinkedListUtils;
import utils.ListNode;

/**
 * <p>
 * Created by Bohan Zheng on 2/9/2016.
 *
 * @author Bohan Zheng
 */
public class RemoveLinkedListElementsTest {
    @Test
    public void test() {
        RemoveLinkedListElements test = new RemoveLinkedListElements();
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 1, 4, 1);
        assertEquals("2,4", LinkedListUtils.serialize(test.removeElements(head, 1)));
    }
}
