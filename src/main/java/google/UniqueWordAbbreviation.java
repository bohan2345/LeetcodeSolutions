package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * Created by Bohan Zheng on 7/1/16.
 *
 * @author Bohan Zheng
 */
public class UniqueWordAbbreviation {
  private Map<String, Set<String>> map;

  public UniqueWordAbbreviation(String[] dictionary) {
    this.map = new HashMap<>(dictionary.length);
    for (String str : dictionary) {
      String abb = abbreviation(str);
      if (this.map.containsKey(abb)) {
        map.get(abb).add(str);
      } else {
        Set<String> s = new HashSet<>();
        s.add(str);
        this.map.put(abb, s);
      }
    }
  }

  private String abbreviation(String str) {
    int leng = str.length();
    if (leng < 3)
      return str;
    else
      return str.charAt(0) + Integer.toString(leng - 2) + str.charAt(leng - 1);
  }

  public boolean isUnique(String word) {
    String abb = abbreviation(word);
    if (!this.map.containsKey(abb)) {
      return true;
    } else {
      if (this.map.get(abb).size() > 1) {
        return false;
      } else {
        return this.map.get(abb).contains(word);
      }
    }
  }
}