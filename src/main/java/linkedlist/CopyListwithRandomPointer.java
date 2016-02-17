package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * <p>
 * Created by Bohan Zheng on 2/16/2016.
 *
 * @author Bohan Zheng
 */
public class CopyListwithRandomPointer {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<Integer, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode newNode = newHead;
        while (node != null) {
            newNode.next = new RandomListNode(node.label);
            newNode = newNode.next;
            map.put(newNode.label, newNode);
            node = node.next;
        }
        node = head;
        while (node != null) {
            RandomListNode random = node.random;
            if (random == null) {
                node = node.next;
                continue;
            }
            map.get(node.label).random = map.get(random.label);
            node = node.next;
        }
        return newHead.next;
    }
}
