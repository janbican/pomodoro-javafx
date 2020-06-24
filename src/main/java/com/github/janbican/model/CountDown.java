package com.github.janbican.model;

import java.util.*;

public class CountDown {
    private final TimeMode mode;
    private Set<CountDownObserver> observers;
    private final Timer timer;
    private int secondsRemaining;

    public CountDown(TimeMode mode, List<CountDownObserver> observers) {
        this.mode = mode;
        this.observers = new HashSet<>(observers);
        timer = new Timer();
        secondsRemaining = mode.getDurationInSeconds();
    }

    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                secondsRemaining -= 1;
                notifyObservers();
                if (secondsRemaining == 0)
                    timer.cancel();
            }
        }, 1000, 1000);
    }

    private void notifyObservers() {
        for (CountDownObserver observer : observers)
            observer.update(secondsRemaining);
    }

    public void stop() {
        timer.cancel();
    }

    public TimeMode getMode() {
        return mode;
    }

    public void addObserver(CountDownObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CountDownObserver observer) {
        observers.remove(observer);
    }

    public int getSecondsRemaining() {
        return secondsRemaining;
    }
}
