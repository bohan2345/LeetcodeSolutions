package design;

import java.util.*;

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
class WordDictionary {

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean hasWord;

        TrieNode() {
            children = new HashMap<>();
            hasWord = false;
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void add(String s) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                Map<Character, TrieNode> children = cur.children;
                TrieNode next = children.getOrDefault(s.charAt(i), new TrieNode());
                cur.children.put(s.charAt(i), next);
                cur = next;
            }
            cur.hasWord = true;
        }

        void search(String s, int index, TrieNode cur, List<String> result, StringBuilder sb) {
            if (index == s.length()) {
                if (cur.hasWord) {
                    result.add(sb.toString());
                }
                return;
            }

            int len = sb.length();
            char c = s.charAt(index);
            if (c != '.') {
                if (!cur.children.containsKey(c)) {
                    return;
                }
                sb.append(c);
                search(s, index + 1, cur.children.get(c), result, sb);
                sb.setLength(len);
            } else {
                for (Character tmp : cur.children.keySet()) {
                    sb.append(tmp);
                    search(s, index + 1, cur.children.get(tmp), result, sb);
                    sb.setLength(len);
                }
            }
        }
    }

    /**
     * Initialize your data structure here.
     */
    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        trie.add(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public List<String> search(String word) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        trie.search(word, 0, trie.root, result, sb);
        return result;
    }
}
