package design;

import java.util.List;

/**
 * <p>
 * Created by Bohan Zheng on 4/20/2016.
 *
 * @author Bohan Zheng
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            TrieNode childNode;
            if (node.getChildren(c) == null) {
                childNode = new TrieNode(c);
                node.setChildren(c, childNode);
            } else {
                childNode = node.getChildren(c);
                int prefixes = childNode.getPrefixes();
                childNode.setPrefixes(prefixes + 1);
            }
            if (i == word.length() - 1) {
                int words = childNode.getWords();
                childNode.setWords(words + 1);
            }
            node = childNode;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = traverseHelper(word);
        return node != null && node.getWords() > 0;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = traverseHelper(prefix);
        return node != null && node.getPrefixes() > 0;
    }

    private TrieNode traverseHelper(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (node.getChildren(c) == null) {
                return null;
            } else {
                node = node.getChildren(c);
            }
        }
        return node;
    }

    static class TrieNode {
        private int words;    // number of whole words, ending at this node
        private int prefixes; // number of words have this node as prefix
        private TrieNode[] children;
        private char value;
        // Initialize your data structure here.
        public TrieNode(char c) {
            value = c;
            children = new TrieNode[26];
            prefixes = 1;
            words = 0;
        }

        public int getWords() {
            return words;
        }

        public void setWords(int words) {
            this.words = words;
        }

        public int getPrefixes() {
            return prefixes;
        }

        public void setPrefixes(int prefixes) {
            this.prefixes = prefixes;
        }

        public TrieNode getChildren(char i) {
            return children[i - 'a'];
        }

        public void setChildren(char i, TrieNode child) {
            this.children[i - 'a'] = child;
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
