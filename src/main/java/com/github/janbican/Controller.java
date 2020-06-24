package com.github.janbican;

import com.github.janbican.model.CountDown;
import com.github.janbican.model.TimeMode;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Arrays;

public class Controller {
    @FXML private Label clockLabel;

    private CountDown countdown;
    private PomodoroClock clock;

    @FXML
    public void initialize() {
        clock = new PomodoroClock(clockLabel);
        countdown = new CountDown(TimeMode.POMODORO, Arrays.asList(clock));
        countdown.start();
    }
}
