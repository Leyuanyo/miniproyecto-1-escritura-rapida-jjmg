package com.example.miniproyecto_escritura_rapida.controller;

import com.example.miniproyecto_escritura_rapida.model.game.Game;
import com.example.miniproyecto_escritura_rapida.view.GameStage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class GameController {

    private AudioClip keySound;
    private AudioClip validateSound;
    private Game mainGame;
    private Timeline timer;

    @FXML private Label levelLabel;
    @FXML private Label timeLabel;
    @FXML private Button validateButton;
    @FXML private Label wordLabel;
    @FXML private TextField wordTextField;

    @FXML
    public void initialize() {
        mainGame = new Game();
        keySound = new AudioClip(
                getClass().getResource("/com/example/miniproyecto_escritura_rapida/Sounds/key-sound.mp3").toExternalForm()
        );
        validateSound = new AudioClip(
                getClass().getResource("/com/example/miniproyecto_escritura_rapida/Sounds/start-sound.mp3").toExternalForm()
        );
        wordLabel.setText(mainGame.startLevel());
        timeLabel.setText("Tiempo restante: " + mainGame.getTimeLeft() + " segundos");
        levelLabel.setText("Nivel: " + mainGame.getLevel());
        startTimer();
    }

    @FXML
    void handleEnterPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            validateSound.play();
            validateAndSave();
        } else {
            keySound.play();
        }
    }

    @FXML
    public void handleValidate(ActionEvent event) {
        validateSound.play();
        validateAndSave();
    }

    private void validateAndSave() {
        String userText = wordTextField.getText();
        if (mainGame.checkAnswer(userText)) {
            stopTimer();
            wordLabel.setText(mainGame.startLevel());
            timeLabel.setText("Tiempo restante: " + mainGame.getTimeLeft() + " segundos");
            levelLabel.setText("Nivel: " + mainGame.getLevel());
            wordTextField.clear();
            wordTextField.requestFocus();
            if (mainGame.isGameWon()) {
                GameStage.loadScene("win-view.fxml");
            } else {
                startTimer();
            }
        } else {
            stopTimer();
            LoseController.timeLeft = mainGame.getTimeLeft();
            LoseController.levelReached = mainGame.getLevel();
            LoseController.loseReason = "Palabra incorrecta";
            GameStage.loadScene("lose-view.fxml");
        }
    }

    private void startTimer() {
        stopTimer();
        timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            mainGame.decrementTime();
            timeLabel.setText("Tiempo restante: " + mainGame.getTimeLeft() + " segundos");
            if (mainGame.isTimeUp()) {
                stopTimer();
                onTimeUp();
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    private void stopTimer() {
        if (timer != null) timer.stop();
    }

    private void onTimeUp() {
        String userText = wordTextField.getText();
        if (mainGame.onTimeUp(userText)) {
            if (mainGame.isGameWon()) {
                GameStage.loadScene("win-view.fxml");
            } else {
                wordLabel.setText(mainGame.startLevel());
                timeLabel.setText("Tiempo restante: " + mainGame.getTimeLeft() + " segundos");
                levelLabel.setText("Nivel: " + mainGame.getLevel());
                wordTextField.clear();
                wordTextField.requestFocus();
                startTimer();
            }
        } else {
            LoseController.timeLeft = mainGame.getTimeLeft();
            LoseController.levelReached = mainGame.getLevel();
            LoseController.loseReason = "Te quedaste sin tiempo";
            GameStage.loadScene("lose-view.fxml");
        }
    }
}