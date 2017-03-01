package datastructure;

/**
 * <p>
 * Created by Bohan Zheng on 10/17/16.
 *
 * @author Bohan Zheng
 */
public class HashFunction {
  /**
   * @param key:       A String you should hash
   * @param HASH_SIZE: An integer
   * @return an integer
   */
  public int hashCode(char[] key, int HASH_SIZE) {
    // write your code here
    long hash = 0;
    for (char aKey : key) {
      hash = ((33 * hash) + aKey) % HASH_SIZE;
    }
    return (int) hash;
  }
}
