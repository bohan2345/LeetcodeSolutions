package google;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains
 * only these two characters: + and -, you and your friend take turns to flip two consecutive
 * "++" into "--". The game ends when a person can no longer make a move and therefore the
 * other person will be the winner.
 * <p>
 * Write a function to determine if the starting player can guarantee a win.
 * <p>
 * For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 * <p>
 * Created by Bohan Zheng on 5/18/2016.
 *
 * @author Bohan Zheng
 */
public class FilpGameII {
  public boolean canWin(String s) {
    return canWin(s.toCharArray());
  }

  private boolean canWin(char[] s) {
    for (int i = 0; i < s.length - 1; i++) {
      if (s[i] == '+' && s[i + 1] == '+') {
        s[i] = '-';
        s[i + 1] = '-';
        boolean f = !canWin(s);
        // need to change s[i] and s[i + 1] back to '+' before return
        s[i] = '+';
        s[i + 1] = '+';
        if (f) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * https://leetcode.com/discuss/64344/theory-matters-from-backtracking-128ms-to-dp-0ms
   */
  public boolean canWin2(String s) {
    s = s.replace('-', ' ');
    int G = 0;
    List<Integer> g = new ArrayList<>();
    for (String t : s.split("[ ]+")) {
      int p = t.length();
      if (p == 0) continue;
      while (g.size() <= p) {
        char[] x = t.toCharArray();
        int i = 0, j = g.size() - 2;
        while (i <= j)
          x[g.get(i++) ^ g.get(j--)] = '-';
        g.add(new String(x).indexOf('+'));
      }
      G ^= g.get(p);
    }
    return G != 0;
  }
}
