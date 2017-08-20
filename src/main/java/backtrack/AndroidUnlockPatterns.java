package backtrack;

public class AndroidUnlockPatterns {
    public int numberOfPatterns(int m, int n) {
        int res = 0;
        for (int i = m; i <= n; i++) {
            for (int x = 1; x <= 9; x++) {
                boolean[] used = new boolean[9];
                used[x - 1] = true;
                res += searchPattern(x, used, i - 1);
                used[x - 1] = false;
            }
        }
        return res;
    }

    private int searchPattern(int current, boolean[] used, int left) {
        if (left == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            if (!used[i - 1] && !invalidPath(current, i, used)) {
                used[i - 1] = true;
                res += searchPattern(i, used, left - 1);
                used[i - 1] = false;
            }
        }
        return res;
    }

    private boolean invalidPath(int from, int to, boolean[] used) {
        switch (from) {
            case 1:
                return (to == 3 && !used[2 - 1]) || (to == 7 && !used[4 - 1]) || (to == 9 && !used[5 - 1]);
            case 2:
                return to == 8 && !used[5 - 1];
            case 3:
                return (to == 1 && !used[2 - 1]) || (to == 7 && !used[5 - 1]) || (to == 9 && !used[6 - 1]);
            case 4:
                return to == 6 && !used[5 - 1];
            case 5:
                return false;
            case 6:
                return to == 4 && !used[5 - 1];
            case 7:
                return (to == 1 && !used[4 - 1]) || (to == 3 && !used[5 - 1]) || (to == 9 && !used[8 - 1]);
            case 8:
                return to == 2 && !used[5 - 1];
            case 9:
                return (to == 1 && !used[5 - 1]) || (to == 3 && !used[6 - 1]) || (to == 7 && !used[8 - 1]);
            default:
                return true;
        }
    }
}
