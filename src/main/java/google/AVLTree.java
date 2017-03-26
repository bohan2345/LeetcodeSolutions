package google;

import utils.TreeNode;

/**
 * <p>
 * Created by Bohan Zheng on 6/2/2016.
 *
 * @author Bohan Zheng
 */
public class AVLTree implements BinarySearchTree {
  BSTNode root;

  public AVLTree(int val) {
    root = new BSTNode(val);
  }

  public BSTNode search(int val) {
    BSTNode node = root;
    while (node != null) {
      if (val < node.val) {
        node = node.left;
      } else if (val > node.val) {
        node = node.right;
      } else {
        return node;
      }
    }
    return null;
  }

  @Override
  public void insert(int val) {
    // find the place to insert;
    BSTNode G = root;
    BSTNode X = new BSTNode(val);
    while (G != null) {
      if (val < G.val) {
        if (G.left == null) {
          X.parent = G;
          G.left = X;
          break;
        }
        G = G.left;
      } else if (val > G.val) {
        if (G.right == null) {
          X.parent = G;
          G.right = X;
          break;
        }
        G = G.right;
      }
    }
    // inserting the new node X as a child of node G
    BSTNode Z;
    while (G != null) {
      Z = X;
      X = G;
      BSTNode N;
      // Z is the child, X is the root, G is parent
      G = X.parent;
      if (X.right.equals(Z)) {
        // Z is the right child, the right subtree increase
        if (X.balanceFactor > 0) {
          // X subtree is right heavy
          if (Z.balanceFactor > 0) {
            // Z subtree is right heavy
            N = rotateLeft(X, Z);
          } else {
            // Z subtree is left heavy
            N = rotateRightLeft(X, Z);
          }
        } else if (X.balanceFactor < 0) {
          // X subtree is left heavy
          X.balanceFactor = 0;
          // height of X subtree not increasing, break the loop
          break;
        } else {
          // X subtree, left == right
          X.balanceFactor = 1;
          continue;
        }
      } else {
        // Z is the left child, the left subtree increase
        if (X.balanceFactor > 0) {
          X.balanceFactor = 0;
          break;
        } else if (X.balanceFactor < 0) {
          if (Z.balanceFactor > 0) {
            N = rotateRight(X, Z);
          } else {
            N = rotateLeftRight(X, Z);
          }
        } else {
          X.balanceFactor = -1;
          continue;
        }
      }

      if (G != null) {
        if (G.left.equals(X)) {
          G.left = N;
        } else {
          G.right = N;
        }
        break;
      } else {
        root = N;
        break;
      }
    }
  }

  @Override
  public void delete(int val) {
    // Let node D be the node which we have to delete,
    // and let node E be a node in the tree we need to find to take node D’s place,
    // and let node N be the actual node we take out of the tree.
    BSTNode D = search(val);
    if (D == null) {
      return;
    }
    if (D.equals(root)) {
      return;
    }
    BSTNode N;
    if (D.right == null) {
      // get the largest value from D.left subtree
      N = D.left;
      while (N.right != null) {
        N = N.right;
      }
      D.val = N.val;
      N.parent.right = N.left;
    } else {
      // get the smallest value from D.right subtree
      N = D.right;
      while (N.left != null) {
        N = N.left;
      }
      D.val = N.val;
      N.parent.left = N.right;
    }
    // rebalance the tree
    BSTNode G = N.parent;
    BSTNode X = G;
    for (; G != null; X = G) {
      // G is the parent, X is the root, Z is the child, N is the root of subtree decrease height
      G = X.parent;
      if (X.right != null && X.right.equals(N)) {
        if (X.balanceFactor < 0) {
          // X is left heavy
          BSTNode Z = X.left;
          if (Z.balanceFactor > 0)
            N = rotateLeftRight(X, Z);
          else
            N = rotateRight(X, Z);
        }
      } else if (X.balanceFactor > 0) {
        N = X;
        X.balanceFactor = 0;
        continue;
      } else {
        X.balanceFactor = -1;
        break; // subtree X height not change
      }
      // N is the new root of the rotated subtree, will take X's place
      if (G != null) {
        if (G.left.equals(X)) {
          G.left = N;
        } else {
          G.right = N;
        }
      } else {
        root = N;
        break;
      }
    }
  }

  /**
   * simple left rotation
   *
   * @param root  root of the subtree to be rotated left
   * @param right right child of the root, not left-heavy
   * @return new root of rebalanced subtree
   */
  private BSTNode rotateLeft(BSTNode root, BSTNode right) {
    BSTNode t23 = right.left;
    root.right = t23;
    if (t23 != null)
      t23.parent = root;
    right.left = root;
    right.parent = root.parent;
    root.parent = right;

    if (right.balanceFactor == 0) {
      root.balanceFactor = 1;
      right.balanceFactor = -1;
    } else {
      root.balanceFactor = 0;
      right.balanceFactor = 0;
    }
    return right;
  }

  /**
   * simple right rotation
   *
   * @param root root of the subtree to be rotated right
   * @param left left child of the root, not right-heavy
   * @return new root of rebalanced subtree
   */
  private BSTNode rotateRight(BSTNode root, BSTNode left) {
    BSTNode t23 = left.right;
    root.left = t23;
    if (t23 != null)
      t23.parent = root;
    left.parent = root.parent;
    left.right = root;
    root.parent = left;

    if (left.balanceFactor == 0) {
      root.balanceFactor = -1;
      left.balanceFactor = 1;
    } else {
      root.balanceFactor = 0;
      left.balanceFactor = 0;
    }
    return left;
  }

  /**
   * right-left double rotation
   *
   * @param root  root of subtree to be rotated
   * @param right right child of the root, left-heavy, height(right) == height(root.left) + 2
   * @return new root of rebalanced subtree
   */
  private BSTNode rotateRightLeft(BSTNode root, BSTNode right) {
    BSTNode Y = right.left;
    BSTNode t3 = Y.right;
    BSTNode t2 = Y.left;
    Y.parent = root.parent;
    Y.left = root;
    root.parent = Y;
    Y.right = right;
    right.parent = Y;
    root.right = t2;
    if (t2 != null)
      t2.parent = root;
    right.left = t3;
    if (t3 != null)
      t3.parent = right;

    if (Y.balanceFactor > 0) {
      right.balanceFactor = 0;
      root.balanceFactor = -1;
    } else if (Y.balanceFactor < 0) {
      root.balanceFactor = 0;
      right.balanceFactor = 1;
    } else {
      right.balanceFactor = 0;
      root.balanceFactor = 0;
    }
    Y.balanceFactor = 0;
    return Y;
  }

  /**
   * left-right double rotation
   *
   * @param root root of subtree to be rotated
   * @param left left child of the root, right-heavy, height(left) == height(root.right) + 2
   * @return new root of rebalanced subtree
   */
  private BSTNode rotateLeftRight(BSTNode root, BSTNode left) {
    BSTNode Y = left.right;
    BSTNode t2 = Y.left, t3 = Y.right;
    Y.parent = root.parent;
    Y.left = left;
    Y.right = root;
    left.parent = Y;
    root.parent = Y;
    left.right = t2;
    if (t2 != null)
      t2.parent = left;
    root.left = t3;
    if (t3 != null)
      t3.parent = root;

    if (Y.balanceFactor > 0) {
      root.balanceFactor = 0;
      left.balanceFactor = -1;
    } else if (Y.balanceFactor < 0) {
      root.balanceFactor = 1;
      left.balanceFactor = 0;
    } else {
      root.balanceFactor = 0;
      left.balanceFactor = 0;
    }
    Y.balanceFactor = 0;
    return Y;
  }

  private class BSTNode extends TreeNode {
    BSTNode left, right, parent;
    int balanceFactor; // balanceFactor = height(right) - height(left)

    BSTNode(int val) {
      super(val);
      balanceFactor = 0;
    }
  }
}
