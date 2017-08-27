package stack;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<TaskAndTime> stack = new Stack<>();
        for (String log : logs) {
            String[] args = log.split(":");
            if (args[1].equals("start")) {
                TaskAndTime taskAndTime = new TaskAndTime(args[0], args[2]);
                if (!stack.isEmpty()) {
                    res[stack.peek().task] += taskAndTime.startTime - stack.peek().startTime;
                }
                stack.push(taskAndTime);
            } else {
                TaskAndTime taskAndTime = stack.pop();
                res[taskAndTime.task] += Integer.valueOf(args[2]) - taskAndTime.startTime + 1;
                if (!stack.isEmpty()) {
                    stack.peek().startTime = Integer.valueOf(args[2]) + 1;
                }
            }
        }
        return res;
    }

    class TaskAndTime {
        int task;
        int startTime;

        TaskAndTime(String task, String startTime) {
            this.task = Integer.valueOf(task);
            this.startTime = Integer.valueOf(startTime);
        }
    }
}
