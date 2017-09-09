package math;

public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] strs = String.valueOf(num).toCharArray();
        int[] maxAfterSelf = new int[strs.length]; // keep index.
        int maxIndex = strs.length - 1;
        for (int i = strs.length - 1; i >= 0; i--) {
            maxIndex = strs[maxIndex] < strs[i] ? i : maxIndex;
            maxAfterSelf[i] = maxIndex;
        }
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] < strs[maxAfterSelf[i]]) {
                swap(strs, i, maxAfterSelf[i]);
                return Integer.valueOf(new String(strs));
            }
        }
        return num;
    }

    private void swap(char[] strs, int i, int j) {
        char tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }
}
