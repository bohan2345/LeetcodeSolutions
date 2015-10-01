package main.array;

import java.util.ArrayList;
import java.util.List;
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
        return res;
    }
}
