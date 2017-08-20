package google;

public class SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        int upper = findUpper(image, x);
        int lower = findLower(image, x);
        int left = findLeft(image, y);
        int right = findRight(image, y);
        return (lower - upper + 1) * (right - left + 1);
    }

    private int findUpper(char[][] image, int x) {
        int lower = x;
        int upper = 0;
        while (lower >= upper) {
            int mid = (lower + upper) / 2;
            if (hasBlackInRow(image, mid)) {
                lower = mid - 1;
            } else {
                upper = mid + 1;
            }
        }
        return hasBlackInRow(image, lower) ? lower : upper;
    }

    private int findLower(char[][] image, int x) {
        int upper = x;
        int lower = image.length - 1;
        while (lower >= upper) {
            int mid = (lower + upper) / 2;
            if (hasBlackInRow(image, mid)) {
                upper = mid + 1;
            } else {
                lower = mid - 1;
            }
        }
        return hasBlackInRow(image, lower) ? lower : upper;
    }

    private int findLeft(char[][] image, int y) {
        int left = 0;
        int right = y;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (hasBlackInCol(image, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return hasBlackInCol(image, left) ? left : right;
    }

    private int findRight(char[][] image, int y) {
        int left = y;
        int right = image[y].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (hasBlackInCol(image, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return hasBlackInCol(image, left) ? left : right;
    }

    private boolean hasBlackInRow(char[][] image, int row) {
        if (row < 0 || row >= image.length) {
            return false;
        }
        for (int i = 0; i < image[row].length; i++) {
            if (image[row][i] == '1') {
                return true;
            }
        }
        return false;
    }

    private boolean hasBlackInCol(char[][] image, int col) {
        if (col < 0 || col >= image[0].length) {
            return false;
        }
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1') {
                return true;
            }
        }
        return false;
    }
}
