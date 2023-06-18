package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class TaskManager {

    private ArrayList<Task> taskList;

    public TaskManager() {
        taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(Task task) {
        taskList.remove(task);
    }

    public void markTaskAsDone(Task task) {
        task.markAsDone();
    }

    public void displayTaskList() {
        for (Task task : taskList) {
            System.out.println(task.getName());
        }
    }

    public void displayDoneTaskList(LocalDate date) {
        for (Task task : taskList) {
            if (task.isDone() && task.getEndDate().equals(date)) {
                System.out.println(task.getName());
            }
        }
    }

    public Optional<Task> findTaskByName(String taskName) {
        for (Task task : taskList) {
            if (task.getName().equals(taskName)) {
                return Optional.of(task);
            }
        }
        return Optional.empty();

    }
}
