package com.github.janbican;

import com.github.janbican.model.CountDownObserver;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class PomodoroClock implements CountDownObserver {
    private final Label clockLabel;

    public PomodoroClock(Label clockLabel) {
        this.clockLabel = clockLabel;
    }

    @Override
    public void update(int seconds) {
        Platform.runLater(() ->
            clockLabel.setText(secondsToString(seconds)));
    }

    private String secondsToString(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
