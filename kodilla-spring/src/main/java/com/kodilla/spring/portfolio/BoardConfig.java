package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {
    @Autowired
    @Qualifier("taskToDo")
    TaskList tastList1;

    @Autowired
    @Qualifier("taskInProgress")
    TaskList tastList2;

    @Autowired
    @Qualifier("taskDone")
    TaskList tastList3;

    @Bean
    public Board getBoard() {
        return new Board(tastList1, tastList2, tastList3);
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
