package linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;
import utils.LinkedListUtils;
import utils.ListNode;

/**
 * <p>
 * Created by Bohan Zheng on 2/17/2016.
 *
 * @author Bohan Zheng
 */
public class AddTwoNumbersTest {
    @Test
    public void test() {
        ListNode l1 = LinkedListUtils.constructLinkedList(5,5);
        ListNode l2 = LinkedListUtils.constructLinkedList(5,5);
        AddTwoNumbers test = new AddTwoNumbers();
        assertEquals("0,1,1", LinkedListUtils.serialize(test.addTwoNumbers(l1, l2)));
    }
}
