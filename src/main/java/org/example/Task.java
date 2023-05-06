package org.example;

import lombok.Data;

import java.time.LocalDate;


@Data
public class Task {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isDone;

    public Task(String name, String description, int i, int i1) {

    }


    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

}
