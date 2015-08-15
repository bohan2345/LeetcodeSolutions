package test;

import java.util.Iterator;

import utils.BST;

public class BSTTest {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>(8, 8);
		bst.insert(3, 3);
		bst.insert(10, 10);
		bst.insert(1, 1);
		bst.insert(6, 6);
		bst.insert(14, 14);
		bst.insert(4, 4);
		bst.insert(7, 7);
		bst.insert(13, 13);

		bst.remove(14);
		// bst.printTree();
		// int s = bst.find(13);
		// System.out.println(s);
		Iterator<Integer> it = bst.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
	}
}
