package com.kodilla.patterns2.observer.homework;


public interface KodillaObservable {
    void registerObserver(KodillaObserver observer1);

    void notifyObservers();

    void removeObserver(KodillaObserver observer1);
}