package google;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int n : nums) {
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
        }
        Map<Integer, Integer> nextNumber = new HashMap<>();
        for (int n : nums) {
            if (frequency.get(n) == 0) {
                // number n is already used in other sequence.
                continue;
            } else if (nextNumber.getOrDefault(n, 0) > 0) {
                // number n can be appended to other sequence.
                nextNumber.put(n, nextNumber.get(n) - 1);
                nextNumber.put(n + 1, nextNumber.getOrDefault(n + 1, 0) + 1);
            } else if (frequency.getOrDefault(n + 1, 0) > 0 && frequency.getOrDefault(n + 2, 0) > 0) {
                // number n can be the start of a sequence.
                frequency.put(n + 1, frequency.get(n + 1) - 1);
                frequency.put(n + 2, frequency.get(n + 2) - 1);
                nextNumber.put(n + 3, nextNumber.getOrDefault(n + 3, 0) + 1);
            } else {
                return false;
            }
            frequency.put(n, frequency.get(n) - 1);
        }
        return true;
    }
}
