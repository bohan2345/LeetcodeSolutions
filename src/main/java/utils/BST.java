package utils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Basic implementation of a Binary Search Tree
 *
 * @param <T>
 * @author Bohan Zheng
 */
public class BST<T> {
    private Node root;

    class Node {
        int key;
        T value;
        Node parent;
        Node left;
        Node right;

        Node(int key, T value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return Integer.toString(this.key);
        }
    }

    public BST(Node root) {
        this.root = root;
    }

    public BST(int key, T value) {
        this.root = new Node(key, value);
    }

    public Node find(int k) {
        Node root = this.root;
        while (root != null) {
            if (root.key == k) {
                return root;
            } else {
                if (k > root.key) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
        return null;
    }

    public Node getMin() {
        Node node = this.root;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node getMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node getMax() {
        Node node = this.root;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public void insert(int k, T value) {
        Node node = this.root;
        Node newNode = new Node(k, value);
        while (node != null) {
            if (k <= node.key) {
                if (node.left == null) {
                    node.left = newNode;
                    newNode.parent = node;
                    return;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right == null) {
                    node.right = newNode;
                    newNode.parent = node;
                    return;
                } else {
                    node = node.right;
                }
            }
        }
    }

    //TODO: debug!!
    public Node remove(int key) {
        Node nodeToRemove = find(key);
        if (nodeToRemove == null) {
            return null;
        }
        Node par = nodeToRemove.parent;
        nodeToRemove.parent = null;
        if (nodeToRemove.left == null && nodeToRemove.right == null) {
            if (par.left.equals(nodeToRemove)) {
                par.left = null;
            } else {
                par.right = null;
            }
        } else if (nodeToRemove.left == null) {
            if (par.left.equals(nodeToRemove)) {
                par.left = nodeToRemove.right;
            } else {
                par.right = nodeToRemove.right;
            }
            nodeToRemove.right = null;
        } else if (nodeToRemove.right == null) {
            if (par.left.equals(nodeToRemove)) {
                par.left = nodeToRemove.left;
            } else {
                par.right = nodeToRemove.left;
            }
            nodeToRemove.left = null;
        } else {
            Node nextMin = getMin(nodeToRemove.right);

            int tmpkey = nodeToRemove.key;
            T tmpvalue = nodeToRemove.value;
            nodeToRemove.key = nextMin.key;
            nodeToRemove.value = nextMin.value;
            nextMin.key = tmpkey;
            nextMin.value = tmpvalue;

            remove(nextMin.key);
        }
        return nodeToRemove;
    }

    public TreeIterator iterator() {
        return new TreeIterator(root);
    }

    public void printTree() {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int cur = 1;
        int next = 0;
        System.out.println(root.key);
        while (!Q.isEmpty()) {
            Node node = Q.poll();
            cur--;
            if (node.left != null) {
                Q.offer(node.left);
                next++;
                System.out.print(node.left.key + ", ");
            } else {
                System.out.print("#" + ", ");
            }
            if (node.right != null) {
                Q.offer(node.right);
                next++;
                System.out.print(node.right.key + ", ");
            } else {
                System.out.print("#" + ", ");
            }

            if (cur == 0) {
                System.out.println("");
                cur = next;
                next = 0;
            }
        }
    }

    final class TreeIterator implements Iterator<T> {
        private Node root;
        private Stack<Node> S = new Stack<>();

        public TreeIterator(Node node) {
            root = node;
        }

        @Override
        public boolean hasNext() {
            return !(root == null && S.isEmpty());
        }

        @Override
        public T next() {
            while (hasNext()) {
                if (root != null) {
                    S.push(root);
                    root = root.left;
                } else {
                    Node node = S.pop();
                    root = node.right;
                    return node.value;
                }
            }
            return null;
        }
    }
}