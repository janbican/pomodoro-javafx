package com.github.janbican.model;

public enum TimeMode {
    POMODORO(1500),
    SHORT_BREAK(300),
    LONG_BREAK(600);

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
