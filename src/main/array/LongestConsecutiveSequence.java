package main.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.<p>
 * For example,
 * Given [100, 4, 200, 1, 3, 2],<br>
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.<p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * Created by Bohan Zheng on 11/15/15.
 *
 * @author Bohan Zheng
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int n : nums) {
            set.add(n);
        }
        int maxLength = 0;
        for (int n : nums) {
            int next = n + 1, prev = n - 1, length = 1;
            while (set.contains(next)) {
                set.remove(next);
                length++;
                next++;
            }
            while (set.contains(prev)) {
                set.remove(prev);
                length++;
                prev--;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}
