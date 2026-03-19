package com.example.miniproyecto_escritura_rapida.controller;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import com.example.miniproyecto_escritura_rapida.view.GameStage;

/**
 * Controller for the Win screen.
 * Manages the animated sequence showing the victory image,
 * displays a congratulations message, and provides options
 * to play again or return to the main menu.
 *
 * @author Juan José Morera Gómez
 * @version 1.0
 * @since 1.0
 * @see GameStage
 * @see GameController
 */
public class WinController {

    /** Sound played when the win screen is shown. */
    private AudioClip WinSound;

    /** Sound played when a navigation button is clicked. */
    private AudioClip buttonSound;

    /** Button that navigates back to the main menu. */
    @FXML
    private Button menuButton;

    /** Button that starts a new game. */
    @FXML
    private Button playAgainButton;

    /** ImageView displaying the victory image. */
    @FXML
    private ImageView youWonImageView;

    /** Label displaying the congratulations message. */
    @FXML
    private Label congratsLabel;

    /** Label displaying the "You Won" message. */
    @FXML
    private Label youWonLabel;

    /**
     * Initializes the Win screen controller.
     * Loads audio resources, sets all UI elements to invisible,
     * plays the win sound, and starts an animated sequence:
     * the victory image fades in, pauses, fades out, then the
     * congratulations message and buttons fade in.
     *
     * @since 1.0
     * @see GameController#validateAndSave()
     * @see GameController#onTimeUp()
     */
    @FXML
    public void initialize() {
        buttonSound = new AudioClip(
                getClass().getResource("/com/example/miniproyecto_escritura_rapida/Sounds/start-sound.mp3").toExternalForm());

        WinSound = new AudioClip(
                getClass().getResource("/com/example/miniproyecto_escritura_rapida/Sounds/win-sound.mp3").toExternalForm()
        );

        youWonImageView.setOpacity(0);
        youWonLabel.setOpacity(0);
        playAgainButton.setOpacity(0);
        menuButton.setOpacity(0);
        congratsLabel.setOpacity(0);


        WinSound.play();
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), youWonImageView);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1.5), youWonImageView);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        fadeIn.setOnFinished(e -> {
            PauseTransition pause = new PauseTransition(Duration.seconds(7));
            pause.setOnFinished(ev -> fadeOut.play());
            pause.play();
        });

        fadeOut.setOnFinished(e -> {
            FadeTransition fadeInfo = new FadeTransition(Duration.seconds(1), youWonLabel);
            fadeInfo.setFromValue(0.0);
            fadeInfo.setToValue(1.0);
            fadeInfo.play();

            FadeTransition fadeOutOfTime = new FadeTransition(Duration.seconds(1), congratsLabel);
            fadeOutOfTime.setFromValue(0.0);
            fadeOutOfTime.setToValue(1.0);
            fadeOutOfTime.play();

            FadeTransition fadePlayAgain = new FadeTransition(Duration.seconds(1), playAgainButton);
            fadePlayAgain.setFromValue(0.0);
            fadePlayAgain.setToValue(1.0);
            fadePlayAgain.play();

            FadeTransition fadeMenu = new FadeTransition(Duration.seconds(1), menuButton);
            fadeMenu.setFromValue(0.0);
            fadeMenu.setToValue(1.0);
            fadeMenu.play();

        });

        fadeIn.setOnFinished(e -> {
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(ev -> fadeOut.play());
            pause.play();
        });

        fadeIn.play();
    }

    /**
     * Initializes the Win screen controller.
     * Loads audio resources, sets all UI elements to invisible,
     * plays the win sound, and starts an animated sequence:
     * the victory image fades in, pauses, fades out, then the
     * congratulations message and buttons fade in.
     *
     * @since 1.0
     * @see GameController#validateAndSave()
     * @see GameController#onTimeUp()
     */
    @FXML
    private void handlePlayAgain() {
        buttonSound.play();
        GameStage.loadScene("game-view.fxml");
    }

    /**
     * Handles the Main Menu button click event.
     * Plays the button sound and navigates back to the main menu scene.
     *
     * @since 1.0
     * @see GameStage#loadScene(String)
     */
    @FXML
    private void handleMenu() {
        buttonSound.play();
        GameStage.loadScene("main-menu-view.fxml");
    }
}