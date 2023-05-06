package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Mark task as done");
            System.out.println("4. List tasks");
            System.out.println("5. List done tasks for a specific date");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Task start date (yyyy-mm-dd): ");
                    LocalDate startDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Task end date (yyyy-mm-dd): ");
                    LocalDate endDate = LocalDate.parse(scanner.nextLine());
                    Task task = new Task("name", "description", 2020, 2022);
                    taskManager.addTask(task);
                    System.out.println("Task added.");
                    break;
                case 2:
                    System.out.print("Enter task name to remove: ");
                    String taskName = scanner.nextLine();
                    Task taskToRemove = taskManager.findTaskByName(taskName);
                    if (taskToRemove != null) {
                        taskManager.removeTask(taskToRemove);
                        System.out.println("Task removed.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter task name to mark as done: ");
                    taskName = scanner.nextLine();
                    Task taskToMarkAsDone = taskManager.findTaskByName(taskName);
                    if (taskToMarkAsDone != null) {
                        taskManager.markTaskAsDone(taskToMarkAsDone);
                        System.out.println("Task marked as done.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 4:
                    taskManager.displayTaskList();
                    break;
                case 5:
                    System.out.print("Enter date (yyyy-mm-dd): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    taskManager.displayDoneTaskList(date);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}