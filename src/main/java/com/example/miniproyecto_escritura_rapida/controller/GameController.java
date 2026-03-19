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

/**
 * Controller for the main game screen.
 * Manages the game loop, timer, word validation, and scene transitions
 * for the Escritura Rapida typing game.
 *
 * @author Juan José Morera Gómez
 * @version 1.0
 * @since 1.0
 * @see Game
 * @see GameStage
 * @see LoseController
 */
public class GameController {

    /** Sound played when the player presses a key. */
    private AudioClip keySound;

    /** Sound played when the player validates a word. */
    private AudioClip validateSound;

    /** The main game model instance. */
    private Game mainGame;

    /** Timeline used to manage the countdown timer. */
    private Timeline timer;

    /** Label displaying the current level. */
    @FXML private Label levelLabel;

    /** Label displaying the remaining time. */
    @FXML private Label timeLabel;

    /** Button used to validate the typed word. */
    @FXML private Button validateButton;

    /** Label displaying the word the player must type. */
    @FXML private Label wordLabel;

    /** Text field where the player types the word. */
    @FXML private TextField wordTextField;

    /**
     * Initializes the game controller.
     * Creates a new game instance, loads audio resources,
     * sets up the initial UI state, and starts the countdown timer.
     *
     * @since 1.0
     */
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

    /**
     * Handles key press events on the word input field.
     * Plays the validate sound and triggers word validation when ENTER is pressed.
     * Plays the key sound for any other key press.
     *
     * @param event the KeyEvent triggered by the player's key press
     * @since 1.0
     */
    @FXML
    void handleEnterPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            validateSound.play();
            validateAndSave();
        } else {
            keySound.play();
        }
    }

    /**
     * Handles the validate button click event.
     * Plays the validate sound and triggers word validation.
     *
     * @param event the ActionEvent triggered by clicking the validate button
     * @since 1.0
     */
    @FXML
    public void handleValidate(ActionEvent event) {
        validateSound.play();
        validateAndSave();
    }

    /**
     * Validates the word typed by the player against the current word.
     * If correct, advances to the next level or triggers the win screen.
     * If incorrect, stops the timer and navigates to the lose screen
     * with the reason "Palabra incorrecta".
     *
     * @since 1.0
     * @see LoseController
     */
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

    /**
     * Starts the countdown timer for the current level.
     * Decrements the game time every second and updates the time label.
     * When time runs out, stops the timer and calls {@link #onTimeUp()}.
     *
     * @since 1.0
     * @see #stopTimer()
     * @see #onTimeUp()
     */
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

    /**
     * Stops the countdown timer if it is currently running.
     *
     * @since 1.0
     * @see #startTimer()
     */
    private void stopTimer() {
        if (timer != null) timer.stop();
    }

    /**
     * Handles the event when the countdown timer reaches zero.
     * Performs a final validation of the player's current input.
     * If correct, advances to the next level or triggers the win screen.
     * If incorrect or empty, navigates to the lose screen
     * with the reason "Te quedaste sin tiempo".
     *
     * @since 1.0
     * @see LoseController
     */
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