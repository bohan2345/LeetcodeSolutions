package string;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * <p>
 * Created by Bohan Zheng on 3/14/2016.
 *
 * @author Bohan Zheng
 */
public class SimplifyPath {
  public String simplifyPath(String path) {
    if (path == null || path.length() == 0) {
      return path;
    }
    Stack<String> stack = new Stack<>();
    String[] paths = path.split("/");
    for (String path1 : paths)
      if (path1.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else if (path1.equals(".") || path1.equals("")) {
      } else {
        stack.push(path1);
      }
    if (stack.isEmpty()) {
      return "/";
    }
    Stack<String> s = new Stack<>();
    while (!stack.isEmpty()) {
      s.push(stack.pop());
    }
    StringBuilder sb = new StringBuilder();
    while (!s.isEmpty()) {
      sb.append('/');
      sb.append(s.pop());
    }
    return sb.toString();
  }
}
