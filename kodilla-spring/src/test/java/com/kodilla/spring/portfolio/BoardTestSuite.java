package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
    @Test
    public void addTaskToDoList() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        String newTask = "Do the laundry";
        board.getToDoList().addTask(newTask);
        //Then
        Assert.assertEquals("Do the laundry", board.getToDoList().getTasks().get(0));
    }

    @Test
    public void addInProgressList() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        String newTask = "Reading Kodilla chapter";
        board.getInProgressList().addTask(newTask);
        //Then
        Assert.assertEquals("Reading Kodilla chapter", board.getInProgressList().getTasks().get(0));
    }

    @Test
    public void addDoneList() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        String newTask = "Exercise 14.3. list of task";
        board.getDoneList().addTask(newTask);
        //Then
        Assert.assertEquals("Exercise 14.3. list of task", board.getDoneList().getTasks().get(0));
    }
}
