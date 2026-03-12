package com.example.miniproyecto_escritura_rapida.controller;

import javafx.scene.media.AudioClip;
import com.example.miniproyecto_escritura_rapida.view.GameStage;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;

public class HowToPlayController {
    private AudioClip escSound;

    @FXML
    public void initialize() {
        escSound = new AudioClip(
                getClass().getResource("/com/example/miniproyecto_escritura_rapida/Sounds/esc-sound.mp3").toExternalForm());
        Platform.runLater(() -> {
            GameStage.getPrimaryStage()
                    .getScene()
                    .setOnKeyPressed(event -> {
                        if (event.getCode() == KeyCode.ESCAPE) {
                            escSound.play();
                            GameStage.loadScene("main-menu-view.fxml");
                        }
                    });
        });
    }
}