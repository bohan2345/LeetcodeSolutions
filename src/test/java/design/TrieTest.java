package design;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 4/20/2016.
 *
 * @author Bohan Zheng
 */
public class TrieTest {
  // Trie trie = new Trie();
  // trie.insert("somestring");
  // trie.search("key");

  @Test
  public void test() {
    Trie trie = new Trie();
    trie.insert("test");
    assertTrue(trie.search("test"));
  }
}
