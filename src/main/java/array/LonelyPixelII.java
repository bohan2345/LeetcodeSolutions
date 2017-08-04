package array;

import java.util.HashMap;
import java.util.Map;

public class LonelyPixelII {
    public int findBlackPixel(char[][] picture, int N) {
        Map<String, Integer> map = new HashMap<>();
        int[] colCount = new int[picture[0].length];
        for (char[] row : picture) {
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 'B') {
                    colCount[j]++;
                }
            }
            String key = new String(row);
            int count = map.getOrDefault(key, 0) + 1;
            map.put(key, count);
        }
        int res = 0;
        for (Map.Entry<String, Integer> row : map.entrySet()) {
            String rowStr = row.getKey();
            if (row.getValue() != N || getBlackPixelNumber(rowStr) != N) {
                continue;
            }
            for (int i = 0; i < rowStr.length(); i++) {
                if (rowStr.charAt(i) == 'B' && colCount[i] == N) {
                    res += row.getValue();
                }
            }
        }
        return res;
    }

    private int getBlackPixelNumber(String row) {
        int count = 0;
        for (char c : row.toCharArray()) {
            if (c == 'B') {
                count++;
            }
        }
        return count;
    }
}
