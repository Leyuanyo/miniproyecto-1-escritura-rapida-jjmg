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

public class WinController {
    private AudioClip WinSound;
    private AudioClip buttonSound;


    @FXML
    private Button menuButton;

    @FXML
    private Button playAgainButton;

    @FXML
    private ImageView youWonImageView;

    @FXML
    private Label congratsLabel;

    @FXML
    private Label youWonLabel;

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