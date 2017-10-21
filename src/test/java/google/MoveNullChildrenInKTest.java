package google;

import org.junit.Test;
import utils.MultiTreeNode;

public class MoveNullChildrenInKTest {
    @Test
    public void test() {
        MoveNullChildrenInK test = new MoveNullChildrenInK();
        MultiTreeNode root = buildTree();
        test.moveNullChildrenInK(root);
    }

    private MultiTreeNode buildTree() {
        MultiTreeNode node1 = new MultiTreeNode(1);
        MultiTreeNode node2 = new MultiTreeNode(2);
        MultiTreeNode node3 = new MultiTreeNode(3);
        MultiTreeNode node4 = new MultiTreeNode(4);
        MultiTreeNode node5 = new MultiTreeNode(5);
        MultiTreeNode node6 = new MultiTreeNode(6);
        MultiTreeNode node7 = new MultiTreeNode(7);
        MultiTreeNode node8 = new MultiTreeNode(8);
        MultiTreeNode node9 = new MultiTreeNode(9);
        MultiTreeNode node10 = new MultiTreeNode(10);

        node1.children.add(node2);
        node1.children.add(null);
        node1.children.add(node3);

        node2.children.add(null);
        node2.children.add(node4);
        node2.children.add(node5);

        node3.children.add(null);
        node3.children.add(node6);
        node3.children.add(node7);

        node4.children.add(node8);
        node4.children.add(node9);
        node4.children.add(node10);
        return node1;
    }
}
