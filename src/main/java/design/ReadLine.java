package design;

public class ReadLine {
    /**
     * 666666666666666666666666666
     */
    int currentRead4 = 0;
    int offset = 0;
    char[] buffer = new char[4];
    StringBuilder sb;
    private String file;

    public void setFile(String file) {
        this.file = file;
    }

    private int read4(char[] buf) {
        int endIndex = Math.min(4, file.length());
        for (int i = 0; i < endIndex; i++) {
            buf[i] = file.charAt(i);
        }
        file = file.substring(endIndex);
        return endIndex;
    }

    String readLine() {
        sb = new StringBuilder();
        while (true) {
            if (currentRead4 == 0) {
                currentRead4 = read4(buffer);
                offset = 0;
                if (currentRead4 == 0) {
                    break;
                }
            }

            while (offset < currentRead4 && buffer[offset] != '\n') {
                sb.append(buffer[offset++]);
            }

            if (offset == currentRead4) {
                currentRead4 = 0;
            } else {
                offset++;
                break; // 遇到 \n了 offset 没有走到最后 break
            }
        }
        return sb.toString();
    }
}
