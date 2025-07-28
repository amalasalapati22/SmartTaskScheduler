package scheduler;
import java.util.PriorityQueue;
public class TaskManager {
	private PriorityQueue<Task> queue = new PriorityQueue<>();

    public void addTask(Task task) {
        queue.offer(task);
    }

    public void deleteTask() {
        if (!queue.isEmpty()) {
            queue.poll();
        }
    }

    public String viewTasks() {
        if (queue.isEmpty()) return "No tasks available.";
        StringBuilder sb = new StringBuilder();
        for (Task task : queue) {
            sb.append(task.toString()).append("\n");
        }
        return sb.toString();
    }
}