package google;

/**
 * <p>
 * Created by Bohan Zheng on 7/9/16.
 *
 * @author Bohan Zheng
 */
public class SearchPrefix {
  public String[] searchPrefix(String[] strs, String prefix) {
    int left = 0, right = strs.length - 1;
    int a = 0, b = 0;
    String[] res = {};
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (prefix(strs[mid], prefix)) {
        a = mid;
        b = mid;
        while (a - 1 >= 0 && prefix(strs[a - 1], prefix)) {
          a--;
        }
        while (b + 1 < strs.length && prefix(strs[b + 1], prefix)) {
          b++;
        }
        res = new String[b - a + 1];
        System.arraycopy(strs, a, res, 0, b - a + 1);
        break;
      } else if (prefix.compareTo(strs[mid]) < 0) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return res;
  }

  private boolean prefix(String str, String prefix) {
    for (int i = 0; i < prefix.length(); i++) {
      if (str.charAt(i) != prefix.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}
