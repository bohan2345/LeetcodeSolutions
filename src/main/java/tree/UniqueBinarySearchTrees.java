package tree;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * <p>
 * 1        3     3      2      1
 * \       /     /      / \      \
 * 3      2     1      1   3      2
 * /     /       \                 \
 * 2     1        2                 3
 * <p>
 * Created by Bohan Zheng on 12/20/15.
 *
 * @author Bohan Zheng
 */
public class UniqueBinarySearchTrees {
  public int numTrees(int n) {
    int[] array = new int[n + 1];
    array[0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++)
        array[i] += array[j - 1] * array[i - j];
    }
    return array[n];
  }
}
