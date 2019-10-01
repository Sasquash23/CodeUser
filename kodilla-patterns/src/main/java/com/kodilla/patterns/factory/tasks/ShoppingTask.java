package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    final String taskName;
    final String whatToBuy;
    final int quantity;
    boolean taskStatus = false;

    public ShoppingTask(final String taskName, final String whatToBuy, final int quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask(){
        System.out.println("Shopping has been done. $$$$... ");
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

    public String getWhatToBuy() {
        return whatToBuy;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isTaskStatus() {
        return taskStatus;
    }
}
