package com.github.janbican;

import com.github.janbican.model.Countdown;
import com.github.janbican.model.TimeMode;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML private Label timeLabel;
    private Countdown countdown;

    @FXML
    public void initialize() {
        countdown = new Countdown(TimeMode.POMODORO);
        timeLabel.textProperty().bind(Bindings.convert(countdown.getSecondsRemaining()));
        countdown.start();
    }
}
