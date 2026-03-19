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
 * Controller for the Game Over (Lose) screen.
 * Manages the animated sequence showing the "You Died" image,
 * displays the reason for losing, the level reached, and the
 * remaining time. Provides options to play again or return to the main menu.
 *
 * @author Juan José Morera Gómez
 * @version 1.0
 * @since 1.0
 * @see GameStage
 * @see GameController
 */
public class LoseController {

    /**
     * Sound played when the lose screen is shown.
     */
    private AudioClip loseSound;

    /** Sound played when a navigation button is clicked. */
    private AudioClip buttonSound;

    /**
     * The level the player reached before losing.
     * Set statically by {@link GameController} before loading this scene.
     */
    public static int levelReached = 0;

    /**
     * The reason the player lost the game.
     * Set statically by {@link GameController} before loading this scene.
     */
    public static String loseReason = "";

    /**
     * The time remaining when the player lost.
     * Set statically by {@link GameController} before loading this scene.
     */
    public static int timeLeft = 0;

    /** Button that navigates back to the main menu. */
    @FXML
    private Button menuButton;

    /** Button that starts a new game. */
    @FXML
    private Button playAgainButton;

    /** Label displaying the level the player reached. */
    @FXML
    private Label reachedLevelLabel;

    /** Label displaying the reason the player lost. */
    @FXML
    private Label reasonLabel;

    /** Label displaying the remaining time when the player lost. */
    @FXML
    private Label timeLeftLabel;

    /** ImageView displaying the "You Died" image. */
    @FXML
    private ImageView youDiedImageView;

    /** Label displaying the "You Lose" message. */
    @FXML
    private Label youLoseLabel;

    /**
     * Initializes the Lose screen controller.
     * Loads audio resources, sets all UI elements to invisible,
     * populates labels with the static game over data, and plays
     * an animated sequence: the "You Died" image fades in, pauses,
     * fades out, then the game summary and buttons fade in.
     *
     * @since 1.0
     * @see GameController#validateAndSave()
     * @see GameController#onTimeUp()
     */
    @FXML
    public void initialize() {
        buttonSound = new AudioClip(
                getClass().getResource("/com/example/miniproyecto_escritura_rapida/Sounds/start-sound.mp3").toExternalForm());

        loseSound = new AudioClip(
                getClass().getResource("/com/example/miniproyecto_escritura_rapida/Sounds/lose-sound.mp3").toExternalForm()


        );

        youDiedImageView.setOpacity(0);
        youLoseLabel.setOpacity(0);
        playAgainButton.setOpacity(0);
        menuButton.setOpacity(0);
        timeLeftLabel.setOpacity(0);
        reachedLevelLabel.setOpacity(0);
        reasonLabel.setOpacity(0);


        loseSound.play();
        timeLeftLabel.setText("Tiempo restante: " + timeLeft);
        reachedLevelLabel.setText("Nivel alcanzado: " + levelReached);
        reasonLabel.setText(loseReason);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), youDiedImageView);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1.5), youDiedImageView);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        fadeIn.setOnFinished(e -> {
            PauseTransition pause = new PauseTransition(Duration.seconds(7));
            pause.setOnFinished(ev -> fadeOut.play());
            pause.play();
        });

        fadeOut.setOnFinished(e -> {
            FadeTransition fadeInfo = new FadeTransition(Duration.seconds(1), youLoseLabel);
            fadeInfo.setFromValue(0.0);
            fadeInfo.setToValue(1.0);
            fadeInfo.play();

            FadeTransition fadeOutOfTime = new FadeTransition(Duration.seconds(1), reasonLabel);
            fadeOutOfTime.setFromValue(0.0);
            fadeOutOfTime.setToValue(1.0);
            fadeOutOfTime.play();

            FadeTransition fadeTimeLeft = new FadeTransition(Duration.seconds(1), timeLeftLabel);
            fadeTimeLeft.setFromValue(0.0);
            fadeTimeLeft.setToValue(1.0);
            fadeTimeLeft.play();

            FadeTransition fadeReachedLevel = new FadeTransition(Duration.seconds(1), reachedLevelLabel);
            fadeReachedLevel.setFromValue(0.0);
            fadeReachedLevel.setToValue(1.0);
            fadeReachedLevel.play();

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
     * Handles the Play Again button click event.
     * Plays the button sound and loads the game scene to start a new game.
     *
     * @since 1.0
     * @see GameStage#loadScene(String)
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