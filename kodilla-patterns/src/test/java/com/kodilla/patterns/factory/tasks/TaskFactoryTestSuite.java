package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shop = taskFactory.createTask(TaskFactory.SHOPPING);
        shop.executeTask();

        //Then
        Assert.assertEquals(true, shop.isTaskExecuted());
        Assert.assertEquals("Buy clothes in H&M", shop.getTaskName());
    }

    @Test
    public void testPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task task = taskFactory.createTask(TaskFactory.PAINTING);
        task.executeTask();

        //Then
        Assert.assertEquals(true, task.isTaskExecuted());
        Assert.assertEquals("Paint bedroom", task.getTaskName());
    }

    @Test
    public void testDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task task = taskFactory.createTask(TaskFactory.DRIVING);
        task.executeTask();

        //Then
        Assert.assertEquals(true, task.isTaskExecuted());
        Assert.assertEquals("Go to work", task.getTaskName());
    }
}
