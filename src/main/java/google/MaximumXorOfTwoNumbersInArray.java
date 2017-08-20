package google;

import java.util.HashSet;
import java.util.Set;

public class MaximumXorOfTwoNumbersInArray {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask = mask | 1 << i;
            Set<Integer> prefixes = new HashSet<>();
            for (int n : nums) {
                prefixes.add(mask & n);
            }
            int tmp = max | 1 << i;
            for (int prefix : prefixes) {
                if (prefixes.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
