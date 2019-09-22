package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {
    @Bean
    @Autowired
    public Board getBoard(TaskList taskToDo, TaskList taskInProgress, TaskList taskDone) {
        return new Board(taskToDo, taskInProgress, taskDone);
    }

    @Bean(name = "taskToDo")
    @Scope("prototype")
    public TaskList createToDoList() {
        return new TaskList();
    }

    @Bean(name = "taskInProgress")
    @Scope("prototype")
    public TaskList createInProgressList() {
        return new TaskList();
    }

    @Bean(name = "taskDone")
    @Scope("prototype")
    public TaskList createDoneList() {
        return new TaskList();
    }
}
