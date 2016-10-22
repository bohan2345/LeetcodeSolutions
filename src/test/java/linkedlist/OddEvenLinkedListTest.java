package linkedlist;

import org.junit.Test;
import utils.LinkedListUtils;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 2/11/2016.
 *
 * @author Bohan Zheng
 */
public class OddEvenLinkedListTest {
    @Test
    public void test() {
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4, 5);
        OddEvenLinkedList test = new OddEvenLinkedList();
        assertEquals("1,3,5,2,4", LinkedListUtils.serialize(test.oddEvenList(head)));
    }
}
