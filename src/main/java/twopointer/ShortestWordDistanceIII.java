package twopointer;

/**
 * <p>
 * Created by Bohan Zheng on 1/17/17.
 *
 * @author Bohan Zheng
 */
public class ShortestWordDistanceIII {
    private static int moveIndex(int i, int j, String[] A, String word) {
        if (i > j) {
            return i;
        }
        i++;
        while (i < A.length) {
            if (A[i].equals(word) && i != j) {
                break;
            }
            i++;
        }
        return i;
    }

    public int shortestWordDistance(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE;
        int index1 = -1, index2 = -1;
        while (index1 < words.length && index2 < words.length) {
            if (index1 <= index2) {
                index1 = moveIndex(index1, index2, words, word1);
            } else {
                index2 = moveIndex(index2, index1, words, word2);
            }
            if (index1 == words.length || index2 == words.length) {
                break;
            }
            if (index2 == -1) {
                continue;
            }
            result = Math.min(result, Math.abs(index1 - index2));
        }
        return result;
    }
}
