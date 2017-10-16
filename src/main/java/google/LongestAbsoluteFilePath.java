package google;

import java.util.Stack;

public class LongestAbsoluteFilePath {
//    public int lengthLongestPath(String input) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(0); // "dummy" length
//        int maxLen = 0;
//        for (String s : input.split("\n")) {
//            int lev = s.lastIndexOf("\t") + 1; // number of "\t"
//            while (lev + 1 < stack.size()) {
//                stack.pop(); // find parent
//            }
//            int len = stack.peek() + s.length() - lev + 1; // remove "/t", add"/"
//            stack.push(len);
//            // check if it is file
//            if (s.contains(".")) {
//                maxLen = Math.max(maxLen, len - 1);
//            }
//        }
//        return maxLen;
//    }
//

    /**
     * dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext
     */
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        Stack<String> dirs = new Stack<>();
        int dirLength = 0;
        int maxLength = 0;
        for (String path : paths) {
            while (!dirs.isEmpty() && getLevel(dirs.peek()) >= getLevel(path)) {
                String last = dirs.pop();
                dirLength -= last.length() - getLevel(last);
            }
            if (path.indexOf('.') >= 0) {
                maxLength = Math.max(maxLength, dirLength + dirs.size() + path.length() - getLevel(path));
                continue;
            }
            dirs.push(path);
            dirLength += path.length() - getLevel(path);
        }
        return maxLength;
    }

    private int getLevel(String path) {
        return path.lastIndexOf("\t") + 1;
    }
}
