package com.kodilla.patterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MentorTest {

    @Test
    public void Should_Update() throws Exception {
        //Given
        ModuleTasks moduleTasks_1 = new ModuleTasks("Group project");
        ModuleTasks moduleTasks_2 = new ModuleTasks("REST API ");

        Mentor mentor_1= new Mentor("Paweł");
        Mentor mentor_2= new Mentor("Marcin");


        moduleTasks_1.registerObserver(mentor_1);
        moduleTasks_2.registerObserver(mentor_2);


        //When
        moduleTasks_1.addTask("task1");
        moduleTasks_1.addTask("task2");
        moduleTasks_1.addTask("task3");
        moduleTasks_1.addTask("task4");
        moduleTasks_1.addTask("task5");


        moduleTasks_2.addTask("task1");
        moduleTasks_2.addTask("task2");

        //Then
        Assert.assertEquals(5,mentor_1.getUpdateCount());
        Assert.assertEquals(2,mentor_2.getUpdateCount());
    }

}