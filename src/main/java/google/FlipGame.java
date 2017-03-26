package google;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains
 * only these two characters: + and -, you and your friend take turns to flip two consecutive
 * "++" into "--". The game ends when a person can no longer make a move and therefore the
 * other person will be the winner.
 * <p>
 * Write a function to compute all possible states of the string after one valid move.
 * <p>
 * For example, given s = "++++", after one move, it may become one of the following states:
 * [
 * "--++",
 * "+--+",
 * "++--"
 * ]
 * <p>
 * Created by Bohan Zheng on 5/18/2016.
 *
 * @author Bohan Zheng
 */
public class FlipGame {
  public List<String> generatePossibleNextMoves(String s) {
    char[] str = s.toCharArray();
    List<String> res = new ArrayList<>();
    for (int i = 0; i < str.length - 1; i++) {
      if (str[i] == '+' && str[i + 1] == '+') {
        str[i] = '-';
        str[i + 1] = '-';
        res.add(new String(str));
        str[i] = '+';
        str[i + 1] = '+';
      }
    }
    return res;
  }
}
