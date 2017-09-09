package design;

import java.util.*;

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
//class AutocompleteSystem {
//    class TrieNode {
//        public TrieNode[] children;
//        public int count;
//        public TrieNode() {
//            children = new TrieNode[27];
//            count = 0;
//        }
//    }
//
//    class Trie {
//        public TrieNode root;
//        public Trie() {
//            root = new TrieNode();
//        }
//
//        public void init(String s, int times) {
//            TrieNode current = root;
//            for (int i = 0; i < s.length(); i++) {
//                current = traverse(s.charAt(i), current);
//            }
//            current.count = times;
//        }
//
//        private TrieNode traverse(char c, TrieNode current) {
//            if (c == ' ') {
//                if (current.children[26] == null) {
//                    current.children[26] = new TrieNode();
//                }
//                current = current.children[26];
//            } else {
//                if (current.children[c - 'a'] == null) {
//                    current.children[c - 'a'] = new TrieNode();
//                }
//                current = current.children[c - 'a'];
//            }
//            return current;
//        }
//
//        public void add(TrieNode current) {
//            current.count++;
//        }
//
//        public TrieNode startWith(TrieNode current, char c, String s, List<Node> result) {
//            TrieNode nextCurrent = current;
//            if (c == ' ') {
//                nextCurrent = current.children[26];
//                dfs(current.children[26], s + c, result);
//            } else if (c != '#') {
//                nextCurrent = current.children[c - 'a'];
//                dfs(current.children[c - 'a'], s + c, result);
//            }
//
//            return nextCurrent;
//        }
//
//        private void dfs(TrieNode current, String s, List<Node> result) {
//            if (current == null) {
//                return;
//            }
//
//            if (current.count > 0) {
//                result.add(new Node(s, current.count));
//            }
//
//            for (int i = 0; i < current.children.length; i++) {
//                if (current.children[i] != null) {
//                    if (i == 26) {
//                        dfs(current.children[i], s + ' ', result);
//                    } else {
//                        dfs(current.children[i], s + (char)('a' + i), result);
//                    }
//                }
//            }
//        }
//    }
//
//    class Node {
//        public String s;
//        public int count;
//        public Node(String ss, int cc) {
//            s = ss;
//            count = cc;
//        }
//    }
//
//    private Trie trie;
//    private TrieNode current;
//    private String prefix;
//    public AutocompleteSystem(String[] sentences, int[] times) {
//        trie = new Trie();
//        for (int i = 0; i < sentences.length; i++) {
//            trie.init(sentences[i], times[i]);
//        }
//        current = trie.root;
//        prefix = "";
//    }
//
//    public List<String> input(char c) {
//        List<Node> result = new ArrayList<>();
//        current = trie.startWith(current, c, prefix, result);
//        prefix += c;
//        if (c == '#') {
//            trie.add(current);
//            prefix = "";
//            current = trie.root;
//        }
//
//        Queue<Node> q = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
//        q.addAll(result);
//        List<String> ff = new ArrayList<>();
//        int num = 3;
//        while (num > 0 && !q.isEmpty()) {
//            ff.add(q.poll().s);
//            num--;
//        }
//        return ff;
//    }
//}