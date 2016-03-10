package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s)<br>
 * from beginWord to endWord, such that:
 * <ol>
 * <li>Only one letter can be changed at a time</li>
 * <li>Each intermediate word must exist in the word list</li>
 * </ol>
 * For example,
 * <p>
 * Given: beginWord = "hit", endWord = "cog" <br>
 * wordList = ["hot","dot","dog","lot","log"]<br>
 * Return <br>
 * [["hit","hot","dot","dog","cog"],<br>
 * ["hit","hot","lot","log","cog"]]
 * <p>
 * Note:<br>
 * All words have the same length.<br>
 * All words contain only lowercase alphabetic characters.<br>
 * <p>
 * Created by Bohan Zheng on 9/30/2015.
 *
 * @author Bohan Zheng
 */
public class WordLadderII {

    /**
     * <ol>
     * <li>BFS from beginword</li>
     * <li>record every step and its parent</li>
     * <li>when find endword, traverse from leaf node to root generate the step list, add to result</li>
     * </ol>
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<>();

        Queue<BfsNode> queue = new LinkedList<>();
        queue.offer(new BfsNode(beginWord, null));
        int cur = 1, next = 0;

        // keep record of all used string, remove from wordList after each level
        Set<String> set = new HashSet<>();

        while (!queue.isEmpty()) {
            BfsNode tmpNode = queue.poll();
            String tmp = tmpNode.value;

            cur--;
            StringBuilder tmpBuilder = new StringBuilder(tmp);
            for (int i = 0; i < tmpBuilder.length(); i++) {
                char originChar = tmp.charAt(i);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == originChar) {
                        continue;
                    }
                    tmpBuilder.setCharAt(i, c);
                    String newStr = tmpBuilder.toString();
                    if (newStr.equals(endWord)) {
                        List<String> path = getPath(tmpNode);
                        path.add(endWord);
                        res.add(new ArrayList<>(path));
                        continue;
                    }
                    if (wordList.contains(newStr)) {
                        queue.add(new BfsNode(newStr, tmpNode));
                        //keep track of used words
                        set.add(newStr);
                        next++;
                    }
                }
                tmpBuilder.setCharAt(i, originChar);
            }

            if (cur == 0) {
                //remove used words
                wordList.removeAll(set);
                if (res.size() != 0) {
                    return res;
                }
                cur = next;
                next = 0;
            }
        }
        return res;
    }

    List<String> getPath(BfsNode node) {
        List<String> res = new ArrayList<>();
        while (node != null) {
            res.add(0, node.value);
            node = node.parent;
        }
        return res;
    }

    class BfsNode {
        String value;
        BfsNode parent;

        BfsNode(String value, BfsNode node) {
            this.value = value;
            this.parent = node;
        }

        @Override
        public String toString() {
            return "BfsNode{" +
                    "value='" + value + '\'' +
                    ", parent=" + parent +
                    '}';
        }
    }
}
