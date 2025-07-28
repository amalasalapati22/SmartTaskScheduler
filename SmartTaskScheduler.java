package scheduler;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SmartTaskScheduler {
	 private static final Scanner scanner = new Scanner(System.in);
	    private static final List<Task> taskList = new ArrayList<>();

	    public static void main(String[] args) {
	        int choice;

	        do {
	            System.out.println("\n===== SMART TASK SCHEDULER MENU =====");
	            System.out.println("1. Add Task");
	            System.out.println("2. View All Tasks");
	            System.out.println("3. Mark Task as Completed");
	            System.out.println("4. Delete Task");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice (1-5): ");
	            choice = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice) {
	                case 1 -> addTask();
	                case 2 -> viewTasks();
	                case 3 -> markTaskCompleted();
	                case 4 -> deleteTask();
	                case 5 -> System.out.println("Exiting. Goodbye!");
	                default -> System.out.println("❗ Invalid choice. Please try again.");
	            }
	        } while (choice != 5);
	    }

	    private static void addTask() {
	        System.out.print("Enter task title: ");
	        String title = scanner.nextLine();

	        System.out.print("Enter priority (1 = High, 2 = Medium, 3 = Low): ");
	        int priority = scanner.nextInt();
	        scanner.nextLine();

	        Task newTask = new Task(title, priority);
	        taskList.add(newTask);

	        System.out.println(" Task added successfully!");
	    }

	    private static void viewTasks() {
	        if (taskList.isEmpty()) {
	            System.out.println(" No tasks available.");
	            return;
	        }
	        taskList.sort(Comparator.comparingInt(Task::getPriority));

	        System.out.println("\n---- TASK LIST (Sorted by Priority) ----");
	        for (int i = 0; i < taskList.size(); i++) {
	            System.out.println((i + 1) + ". " + taskList.get(i));
	        }
	    }

	    private static void markTaskCompleted() {
	        if (taskList.isEmpty()) {
	            System.out.println(" No tasks to update.");
	            return;
	        }

	        viewTasks();
	        System.out.print("Enter task number to mark as completed: ");
	        int index = scanner.nextInt();
	        scanner.nextLine();

	        if (index >= 1 && index <= taskList.size()) {
	            taskList.get(index - 1).setCompleted(true);
	            System.out.println("Task marked as completed!");
	        } else {
	            System.out.println("❗ Invalid task number.");
	        }
	    }

	    private static void deleteTask() {
	        if (taskList.isEmpty()) {
	            System.out.println(" No tasks to delete.");
	            return;
	        }

	        viewTasks();
	        System.out.print("Enter task number to delete: ");
	        int index = scanner.nextInt();
	        scanner.nextLine();

	        if (index >= 1 && index <= taskList.size()) {
	            taskList.remove(index - 1);
	            System.out.println("Task deleted successfully!");
	        } else {
	            System.out.println("❗ Invalid task number.");
	        }
	    }
	}