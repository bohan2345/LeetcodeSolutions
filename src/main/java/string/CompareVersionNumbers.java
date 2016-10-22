package string;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * <p>
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level
 * revision of the second first-level revision.
 * <p>
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 * <p>
 * Created by Bohan Zheng on 4/25/2016.
 *
 * @author Bohan Zheng
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        int i = 0;
        while (i < v1s.length || i < v2s.length) {
            Integer int1, int2;
            if (i >= v1s.length) {
                int1 = 0;
            } else {
                int1 = Integer.valueOf(v1s[i]);
            }
            if (i >= v2s.length) {
                int2 = 0;
            } else {
                int2 = Integer.valueOf(v2s[i]);
            }
            if (!int1.equals(int2)) {
                return int1.compareTo(int2);
            }
            i++;
        }
        return 0;
    }
}
