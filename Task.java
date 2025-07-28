package scheduler;

public class Task implements Comparable<Task> {
    private String title;
    private int priority;

    public Task(String title, int priority) {
        this.title = title;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);  // Lower number = higher priority
    }

    @Override
    public String toString() {
        return "Task: " + title + " | Priority: " + priority;
    }
}