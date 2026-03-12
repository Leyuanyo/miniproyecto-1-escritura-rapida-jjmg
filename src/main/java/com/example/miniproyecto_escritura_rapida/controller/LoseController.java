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

public class LoseController {
    private AudioClip loseSound;
    private AudioClip buttonSound;
    public static int levelReached = 0;
    public static String loseReason = "";
    public static int timeLeft = 0;

    @FXML
    private Button menuButton;

    @FXML
    private Button playAgainButton;

    @FXML
    private Label reachedLevelLabel;

    @FXML
    private Label reasonLabel;

    @FXML
    private Label timeLeftLabel;

    @FXML
    private ImageView youDiedImageView;

    @FXML
    private Label youLoseLabel;

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

    @FXML
    private void handlePlayAgain() {
        buttonSound.play();
        GameStage.loadScene("game-view.fxml");
    }

    @FXML
    private void handleMenu() {
        buttonSound.play();
        GameStage.loadScene("main-menu-view.fxml");
    }
}