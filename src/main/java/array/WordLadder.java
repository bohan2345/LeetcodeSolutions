package array;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 * <ol>
 * <li>Only one letter can be changed at a time</li>
 * <li>Each intermediate word must exist in the word list</li>
 * </ol>
 * For example,
 * <p>
 * Given:<br>
 * beginWord = "hit"<br>
 * endWord = "cog"<br>
 * wordList = ["hot","dot","dog","lot","log"]<br>
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",<br>
 * return its length 5.
 * <p>
 * Note:
 * <ul>
 * <li>Return 0 if there is no such transformation sequence.</li>
 * <li>All words have the same length.</li>
 * <li>All words contain only lowercase alphabetic characters.</li>
 * </ul>
 * <p>
 * Created by Bohan Zheng on 9/23/15.
 *
 * @author Bohan Zheng
 */
public class WordLadder {
  // use bfs to get the shortest distance
  public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    int step = 1, cur = 1, next = 0;
    while (!queue.isEmpty()) {
      String str = queue.poll();
      StringBuilder sb = new StringBuilder(str);
      cur--;
      for (int i = 0; i < sb.length(); i++) {
        char originalChar = sb.charAt(i);
        for (char c = 'a'; c <= 'z'; c++) {
          if (c == originalChar) {
            continue;
          }
          sb.setCharAt(i, c);
          String newStr = sb.toString();
          if (newStr.equals(endWord)) {
            return step + 1;
          }
          if (wordList.contains(newStr)) {
            queue.offer(newStr);
            wordList.remove(newStr);
            next++;
          }
        }
        sb.setCharAt(i, originalChar);
      }
      if (cur == 0) {
        step++;
        cur = next;
        next = 0;
      }
    }
    return 0;
  }
}
