package com.github.janbican.model;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Timer;
import java.util.TimerTask;

public class Countdown {
    private final TimeMode mode;
    private final Timer timer;
    private final IntegerProperty secondsRemaining;

    public Countdown(TimeMode mode) {
        this.mode = mode;
        timer = new Timer();
        secondsRemaining = new SimpleIntegerProperty(
                this, "secondsRemaining", mode.getDurationInSeconds());
    }

    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() ->
                    secondsRemaining.set(secondsRemaining.get() - 1));
            }
        }, 1000, 1000);
    }

    public void stop() {
        timer.cancel();
    }

    public TimeMode getMode() {
        return mode;
    }

    public IntegerProperty getSecondsRemaining() {
        return secondsRemaining;
    }
}
