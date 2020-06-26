package com.github.janbican;

import com.github.janbican.model.CountDown;
import com.github.janbican.model.TimeMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Collections;

public class Controller {
    @FXML private Label clockLabel;
    @FXML private Button pomodoroBtn;
    @FXML private Button shortBreakBtn;
    @FXML private Button longBreakBtn;

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

    public void pomodoroButtonClicked(ActionEvent event) {
        changeMode(TimeMode.POMODORO);
        highlightButton((Button) event.getSource());
    }

    private void changeMode(TimeMode mode) {
        countdown.stop();
        countdown.setMode(mode);
        countdown.start();
    }

    private void highlightButton(Button button) {
        removeCurrentHighlighting();
        button.getStyleClass().add("highlightBtn");
    }

    private void removeCurrentHighlighting() {
        pomodoroBtn.getStyleClass().remove("highlightBtn");
        shortBreakBtn.getStyleClass().remove("highlightBtn");
        longBreakBtn.getStyleClass().remove("highlightBtn");
    }

    public void shortBreakButtonClicked(ActionEvent event) {
        changeMode(TimeMode.SHORT_BREAK);
        highlightButton((Button) event.getSource());
    }

    public void longBreakButtonClicked(ActionEvent event) {
        changeMode(TimeMode.LONG_BREAK);
        highlightButton((Button) event.getSource());
    }
}
