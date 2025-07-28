package scheduler;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TaskManagerApp extends Application {

    private TaskManager taskManager = new TaskManager();
    private TextArea taskListArea = new TextArea();

    public static void main(String[] args) {
    	launch(args);
    }

    @Override
    public void start(Stage stage) {
        
        TextField taskField = new TextField();
        taskField.setPromptText("Enter task title");

        TextField priorityField = new TextField();
        priorityField.setPromptText("Enter priority (1=High, 5=Low)");

        Button addButton = new Button("Add Task");
        Button viewButton = new Button("View Tasks");
        Button deleteButton = new Button("Delete Top Priority Task");

        taskListArea.setEditable(false);
        
        addButton.setOnAction(e -> {
            String title = taskField.getText();
            String priorityText = priorityField.getText();
            if (title.isEmpty() || priorityText.isEmpty()) {
                showAlert("Please enter both title and priority.");
                return;
            }
            try {
                int priority = Integer.parseInt(priorityText);
                taskManager.addTask(new Task(title, priority));
                taskField.clear();
                priorityField.clear();
                showAlert("Task added successfully.");
            } catch (NumberFormatException ex) {
                showAlert("Priority must be a number.");
            }
        });

        viewButton.setOnAction(e -> {
            taskListArea.setText(taskManager.viewTasks());
        });

        deleteButton.setOnAction(e -> {
            taskManager.deleteTask();
            taskListArea.setText(taskManager.viewTasks());
        });

        VBox inputBox = new VBox(10, taskField, priorityField, addButton, viewButton, deleteButton);
        inputBox.setPadding(new Insets(10));
        BorderPane root = new BorderPane();
        root.setLeft(inputBox);
        root.setCenter(taskListArea);

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Smart Task Scheduler");
        stage.show();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}