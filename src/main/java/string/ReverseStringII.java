package string;

public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; ) {
            reverse(str, i, i + k);
            i += 2 * k;
        }
        return new String(str);
    }

    private void reverse(char[] str, int start, int end) {
        int i = start;
        int j = Math.min(str.length - 1, end - 1);
        while (i < j) {
            char temp = str[i];
            str[i++] = str[j];
            str[j--] = temp;
        }
    }
}
