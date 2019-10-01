package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task createTask(final String taskType) {
        switch (taskType) {
            case SHOPPING:
                return new ShoppingTask("Buy clothes in H&M", "Skirt", 2);
            case PAINTING:
                return new PaintingTask("Paint bedroom", "blue", "wall");
            case DRIVING:
                return new DrivingTask("Go to work", "work", "MiniCooper");
            default:
                return null;
        }

    }
}
