package com.kodilla.patterns.factory.tasks;

import java.util.Objects;

public class PaintingTask implements Task {
    final String taskName;
    final String color;
    final String whatToPaint;
    boolean taskStatus = false;

    public PaintingTask(final String taskName,final String color,final String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        System.out.println("Painting has been done :)");
        taskStatus = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return taskStatus;
    }

    public String getColor() {
        return color;
    }

    public String getWhatToPaint() {
        return whatToPaint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaintingTask that = (PaintingTask) o;
        return taskStatus == that.taskStatus && Objects.equals(taskName, that.taskName) && Objects.equals(color, that.color) && Objects.equals(whatToPaint, that.whatToPaint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskName, color, whatToPaint, taskStatus);
    }
}
