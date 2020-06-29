package com.github.janbican.model;

import java.util.*;

public final class CountDown {
    private CountDownObserver observer;
    private TimeMode mode;
    private Timer timer;
    private int secondsRemaining;
    private boolean isRunning;

    public CountDown(TimeMode mode, CountDownObserver observer) {
        this.observer = Objects.requireNonNull(observer);
        this.mode = mode;
        secondsRemaining = mode.getSeconds();
        isRunning = false;
    }

    public void start() {
        if (!isRunning && secondsRemaining != 0) {
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
                observer.update(secondsRemaining);
                if (secondsRemaining == 0)
                    timeIsUp();
            }
        }, 1000, 1000);
    }

    private void timeIsUp() {
        isRunning = false;
        timer.cancel();
        observer.timeIsUp();
    }

    public void stop() {
        if (isRunning) {
            isRunning = false;
            timer.cancel();
        }
    }

    public void reset() {
        secondsRemaining = mode.getSeconds();
        observer.update(secondsRemaining);
    }

    public TimeMode getMode() {
        return mode;
    }

    public void setMode(TimeMode mode) {
        stop();
        this.mode = mode;
        reset();
    }

    public CountDownObserver getObserver() {
        return observer;
    }

    public void setObserver(CountDownObserver observer) {
        this.observer = observer;
    }

    public int getSecondsRemaining() {
        return secondsRemaining;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean isTimeUp() {
        return secondsRemaining == 0;
    }
}
