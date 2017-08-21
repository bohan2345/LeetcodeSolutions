package google;

public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if (words.length == 0) {
            return 0;
        }
        int[] wordChar = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                wordChar[i] |= 1 << c - 'a';
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((wordChar[i] & wordChar[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
