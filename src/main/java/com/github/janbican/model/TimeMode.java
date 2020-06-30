package com.github.janbican.model;

public enum TimeMode {
    POMODORO(25),
    SHORT_BREAK(5),
    LONG_BREAK(10);

    private int seconds;

    TimeMode(int minutes) {
        seconds = minutes * 60;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return seconds / 60;
    }

    public void setMinutes(int minutes) {
        seconds = minutes * 60;
    }
}
