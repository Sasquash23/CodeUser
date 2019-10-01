package com.kodilla.patterns.factory.tasks;

import java.util.Objects;

public class DrivingTask implements Task {
    final String taskName;
    final String where;
    final String using;
    boolean taskStatus = false;

    public DrivingTask(final String taskName, final String where, final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask(){
        System.out.println("You have drived.");
        taskStatus = true;
    }

    @Override
    public String getTaskName(){
        return taskName;
    }

    @Override
    public boolean isTaskExecuted(){
        return taskStatus;
    }

    public String getWhere() {
        return where;
    }

    public String getUsing() {
        return using;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrivingTask that = (DrivingTask) o;
        return taskStatus == that.taskStatus && Objects.equals(taskName, that.taskName) && Objects.equals(where, that.where) && Objects.equals(using, that.using);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskName, where, using, taskStatus);
    }
}
