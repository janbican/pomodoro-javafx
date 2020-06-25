package com.github.janbican.model;

import java.util.*;

public final class CountDown {
    private final TimeMode mode;
    private final Set<CountDownObserver> observers;
    private Timer timer;
    private int secondsRemaining;
    private boolean isRunning;

    public CountDown(TimeMode mode, List<CountDownObserver> observers) {
        this.mode = mode;
        this.observers = new HashSet<>(observers);
        secondsRemaining = mode.getDurationInSeconds();
        isRunning = false;
    }

    public void start() {
        if (!isRunning) {
            isRunning = true;
            timer = new Timer();
            startCountDown();
        }
    }

    private void startCountDown() {
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
        if (isRunning) {
            isRunning = false;
            timer.cancel();
        }
    }

    public void reset() {
        stop();
        secondsRemaining = mode.getDurationInSeconds();
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

    public boolean isRunning() {
        return isRunning;
    }
}
