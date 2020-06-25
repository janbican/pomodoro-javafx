package com.github.janbican;

import com.github.janbican.model.CountDown;
import com.github.janbican.model.TimeMode;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Collections;

public class Controller {
    @FXML private Label clockLabel;

    private CountDown countdown;
    private PomodoroClock clock;

    @FXML
    public void initialize() {
        clock = new PomodoroClock(clockLabel, TimeMode.POMODORO);
        countdown = new CountDown(TimeMode.POMODORO, Collections.singletonList(clock));
    }

    public void startButtonClicked() {
        countdown.start();
    }

    public void stopButtonClicked() {
        countdown.stop();
    }

    public void resetButtonClicked() {
        countdown.reset();
        clock.set(countdown.getMode());
    }

    public void pomodoroButtonClicked() {
        changeMode(TimeMode.POMODORO);
    }

    private void changeMode(TimeMode mode) {
        countdown.stop();
        countdown = new CountDown(mode, Collections.singletonList(clock));
        countdown.start();
    }

    public void shortBreakButtonClicked() {
        changeMode(TimeMode.SHORT_BREAK);
    }

    public void longBreakButtonClicked() {
        changeMode(TimeMode.LONG_BREAK);
    }
}
