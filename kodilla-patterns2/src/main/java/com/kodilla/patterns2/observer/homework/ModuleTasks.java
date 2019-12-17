package com.kodilla.patterns2.observer.homework;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ModuleTasks implements KodillaObservable {
    private List<KodillaObserver> kodillaObservers;
    private final List<String> tasks;
    private final String studentName;

    public ModuleTasks(String moduleTitle) {
        this.kodillaObservers = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.studentName = moduleTitle;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }


    @Override
    public void registerObserver(KodillaObserver observer) {
        kodillaObservers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (KodillaObserver observer : kodillaObservers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(KodillaObserver observer) {
        kodillaObservers.remove(observer);
    }
}
