package com.kodilla.patterns2.observer.homework;

import lombok.Getter;

@Getter
public class Mentor implements KodillaObserver {
    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(ModuleTasks moduleTasks) {
        System.out.println(mentorName + ": New task in queue of trainee: " + moduleTasks.getStudentName() + "\n" +
                " (total: " + moduleTasks.getTasks().size() + " tasks)");
        updateCount++;
    }
}
