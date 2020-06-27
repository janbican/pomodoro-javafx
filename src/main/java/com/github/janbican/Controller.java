package com.github.janbican;

import com.github.janbican.model.CountDown;
import com.github.janbican.model.TimeMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.util.Collections;

public class Controller {
    @FXML private Label clockLabel;
    @FXML private ProgressBar clockProgressBar;
    @FXML private Button toggleBtn;
    @FXML private Button pomodoroBtn;
    @FXML private Button shortBreakBtn;
    @FXML private Button longBreakBtn;

    private CountDown countdown;
    private PomodoroClock clock;

    @FXML
    public void initialize() {
        clock = new PomodoroClock(clockLabel, clockProgressBar, TimeMode.POMODORO);
        countdown = new CountDown(TimeMode.POMODORO, Collections.singletonList(clock));
    }

    public void toggleBtnClicked() {
        if (countdown.isRunning())
            stop();
        else
            start();
    }

    private void stop() {
        countdown.stop();
        updateToggleBtn("START");
    }

    private void updateToggleBtn(String text) {
        toggleBtn.setText(text);
    }

    private void start() {
        countdown.start();
        updateToggleBtn("STOP");
    }

    public void pomodoroBtnClicked(ActionEvent event) {
        changeMode(TimeMode.POMODORO);
        highlightButton((Button) event.getSource());
    }

    private void changeMode(TimeMode mode) {
        countdown.stop();
        countdown.setMode(mode);
        clock.setMode(mode);
        start();
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

    public void shortBreakBtnClicked(ActionEvent event) {
        changeMode(TimeMode.SHORT_BREAK);
        highlightButton((Button) event.getSource());
    }

    public void longBreakBtnClicked(ActionEvent event) {
        changeMode(TimeMode.LONG_BREAK);
        highlightButton((Button) event.getSource());
    }
}
