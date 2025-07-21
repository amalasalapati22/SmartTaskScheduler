package scheduler;

public class Task {
	 private String title;
	    private int priority;
	    private boolean isCompleted;

	    public Task(String title, int priority) {
	        this.title = title;
	        this.priority = priority;
	        this.isCompleted = false;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public int getPriority() {
	        return priority;
	    }

	    public boolean isCompleted() {
	        return isCompleted;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public void setPriority(int priority) {
	        this.priority = priority;
	    }

	    public void setCompleted(boolean completed) {
	        isCompleted = completed;
	    }

	    public String toString() {
	        return "[ " + title + " | Priority: " + priority + " | Completed: " + isCompleted + " ]";
	    }
}