package com.github.janbican.model;

public enum TimeMode {
    POMODORO(20),
    SHORT_BREAK(10),
    LONG_BREAK(20);

    private int durationInSeconds;

    TimeMode(int seconds) {
        this.durationInSeconds = seconds;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int seconds) {
        durationInSeconds = seconds;
    }
}
