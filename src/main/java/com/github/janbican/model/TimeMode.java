package com.github.janbican.model;

public enum TimeMode {
    POMODORO(10),
    SHORT_BREAK(4),
    LONG_BREAK(7);

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
