package com.github.janbican;

import com.github.janbican.model.CountDownObserver;
import com.github.janbican.model.TimeMode;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class PomodoroClock implements CountDownObserver {
    private final Label clockLabel;
    private final ProgressBar progressBar;
    private TimeMode mode;

    public PomodoroClock(Label clockLabel,
                         ProgressBar progressBar,
                         TimeMode mode) {
        this.clockLabel = clockLabel;
        this.progressBar = progressBar;
        setMode(mode);
    }

    private void set(TimeMode mode) {
        clockLabel.setText(secondsToString(mode.getDurationInSeconds()));
    }

    @Override
    public void update(int seconds) {
        Platform.runLater(() -> {
            clockLabel.setText(secondsToString(seconds));
            updateProgressBar(seconds);
        });
    }

    private String secondsToString(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    private void updateProgressBar(int seconds) {
        progressBar.setProgress((float) seconds / mode.getDurationInSeconds());
    }

    public void setMode(TimeMode mode) {
        this.mode = mode;
        clockLabel.setText(secondsToString(mode.getDurationInSeconds()));
        progressBar.setProgress(1);
    }
}
