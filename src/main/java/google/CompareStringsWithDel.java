package google;

public class CompareStringsWithDel {
    public boolean compareStrings(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        int countA = 0;
        int countB = 0;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '#' || b.charAt(j) == '#') {
                if (a.charAt(i) == '#') {
                    i--;
                    countA++;
                }

                if (b.charAt(j) == '#') {
                    j--;
                    countB++;
                }
            } else {
                if (countA == 0 && countB == 0) {
                    if (a.charAt(i) != b.charAt(j)) {
                        return false;
                    } else {
                        i--;
                        j--;
                    }
                } else {
                    if (countA > 0) {
                        countA--;
                        i--;
                    }

                    if (countB > 0) {
                        countB--;
                        j--;
                    }
                }

            }
        }

        while (i >= 0) {
            if (a.charAt(i) == '#') {
                countA++;
                i--;
            } else {
                if (countA == 0) {
                    return false;
                }
                i--;
            }
        }

        while (j >= 0) {
            if (b.charAt(j) == '#') {
                countB++;
                j--;
            } else {
                if (countB == 0) {
                    return false;
                }
                j--;
            }
        }
        return true;
    }
}
