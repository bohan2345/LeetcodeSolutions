package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * Below is one possible representation of s1 = "great":
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * We say that "rgeat" is a scrambled string of "great".
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * We say that "rgtae" is a scrambled string of "great".
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * https://leetcode.com/problems/scramble-string/
 * <p>
 * Created by Bohan Zheng on 4/13/2016.
 *
 * @author Bohan Zheng
 */
public class ScrambleString {
  /**
   * 三维动态规划题目：
   * <p>
   * 我们提出维护量res[i][j][n]，其中i是s1的起始字符，j是s2的起始字符，而n是当前的字符串长度，res[i][j][len]表示的是以i和j分别为
   * s1和s2起点的长度为len的字符串是不是互为scramble。有了维护量我们接下来看看递推式，也就是怎么根据历史信息来得到res[i][j][len]。
   * 判断这个是不是满足，其实我们首先是把当前s1[i...i+len-1]字符串劈一刀分成两部分，然后分两种情况：
   * 第一种是左边和s2[j...j+len-1]左边部分是不是scramble，以及右边和s2[j...j+len-1]右边部分是不是scramble；
   * 第二种情况是左边和s2[j...j+len-1]右边部分是不是scramble，以及右边和s2[j...j+len-1]左边部分是不是scramble。
   * 如果以上两种情况有一种成立，说明s1[i...i+len-1]和s2[j...j+len-1]是scramble的。
   * 而对于判断这些左右部分是不是scramble我们是有历史信息的，因为长度小于n的所有情况我们都在前面求解过了（也就是长度是最外层循环）。
   * 上面说的是劈一刀的情况，对于s1[i...i+len-1]我们有len-1种劈法，在这些劈法中只要有一种成立，那么两个串就是scramble的。
   * 总结起来递推式是res[i][j][len] = || (res[i][j][k]&&res[i+k][j+k][len-k] || res[i][j+len-k][k]&&res[i+k][j][len-k])
   * 对于所有1<=k如此总时间复杂度因为是三维动态规划，需要三层循环，加上每一步需要线行时间求解递推式，所以是O(n^4)。
   * 虽然已经比较高了，但是至少不是指数量级的，动态规划还是相当有用的，空间复杂度是O(n^3)。代码如下：
   * <p>
   * Another way is to use DP. I use a three dimension array scramble[][][] to save the states.
   * What scramble[k][i][j] means is that two substrings of length k, one starts from i of string s1,
   * another one starts from j of string s2, are scramble. We are trying to find scramble[L][0][0].
   * For every length k, we try to divide the string to two parts differently, checking if there is a way that can make it true.
   */
  public static boolean isScramble2(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }

    int len = s1.length();

    if (s2.length() != len) {
      return false;
    }

    boolean[][][] D = new boolean[len][len][len + 1];

    // D[i][j][k] = D[i][]
    for (int k = 1; k <= len; k++) {
      // 注意这里的边界选取。 如果选的不对，就会发生越界的情况.. orz..
      // attention: should use "<="
      for (int i = 0; i <= len - k; i++) {
        for (int j = 0; j <= len - k; j++) {
          if (k == 1) {
            D[i][j][k] = s1.charAt(i) == s2.charAt(j);
            continue;
          }

          D[i][j][k] = false;
          for (int l = 1; l <= k - 1; l++) {
            if (D[i][j][l] && D[i + l][j + l][k - l]
                || D[i][j + k - l][l] && D[i + l][j][k - l]) {
              D[i][j][k] = true;
              break;
            }
          }
        }
      }
    }

    return D[0][0][len];
  }

  public boolean isScramble(String s1, String s2) {
    if (s1.equals(s2)) {
      return true;
    }
    int leng1 = s1.length(), leng2 = s2.length();
    if (leng1 != leng2 || !hasSameCharacters(s1, s2)) {
      return false;
    }
    for (int i = 1; i < leng1; ++i) {
      String sub11 = s1.substring(0, i);
      String sub12 = s1.substring(i);
      String sub21 = s2.substring(0, i);
      String sub22 = s2.substring(i);
      if (isScramble(sub11, sub21) && isScramble(sub12, sub22)) {
        return true;
      }
      sub21 = s2.substring(leng2 - i, leng2);
      sub22 = s2.substring(0, leng2 - i);
      if (isScramble(sub11, sub21) && isScramble(sub12, sub22)) {
        return true;
      }
    }
    return false;
  }

  private boolean hasSameCharacters(String s1, String s2) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s1.length(); ++i) {
      char c = s1.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }
    for (int i = 0; i < s2.length(); ++i) {
      char c = s2.charAt(i);
      if (map.containsKey(c)) {
        int count = map.get(c) - 1;
        if (count == 0) {
          map.remove(c);
        } else {
          map.put(c, count);
        }
      } else {
        return false;
      }
    }
    return map.isEmpty();
  }
}
