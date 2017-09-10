package design;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class AutocompleteSystem {
    private TrieNode root;
    private TrieNode current;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode("");
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
        current = root;
    }

    public List<String> input(char c) {
        if (c == '#') {
            current.count++;
            current = root;
            return new ArrayList<>();
        }
        int index = getIndex(c);
        TrieNode child = current.children[index];
        if (child == null) {
            child = new TrieNode(current.prev + c);
            current.children[index] = child;
        }
        current = child;
        return getTopThree(current);
    }

    private int getIndex(char c) {
        if (c == ' ') {
            return 26;
        } else {
            return c - 'a';
        }
    }

    private List<String> getTopThree(TrieNode root) {
        PriorityQueue<TrieNode> queue = new PriorityQueue<>((n1, n2) -> {
            if (n1.count != n2.count) {
                return Integer.compare(n1.count, n2.count);
            } else {
                return n2.prev.compareTo(n1.prev);
            }
        });
        Stack<TrieNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TrieNode node = stack.pop();
            if (node.count > 0) {
                queue.offer(node);
                if (queue.size() > 3) {
                    queue.poll();
                }
            }
            for (TrieNode child : node.children) {
                if (child != null) {
                    stack.push(child);
                }
            }
        }
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(0, queue.poll().prev);
        }
        return res;
    }

    private void insert(String sentence, int time) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            int index = getIndex(c);
            TrieNode next = node.children[index];
            if (next == null) {
                next = new TrieNode(node.prev + c);
                node.children[index] = next;
            }
            node = next;
        }
        node.count = time;
    }

    private class TrieNode {
        TrieNode[] children;
        int count;
        String prev;

        TrieNode(String prev) {
            this.children = new TrieNode[27];
            count = 0;
            this.prev = prev;
        }
    }
}
