package com.example.miniproyecto_escritura_rapida.controller;

import javafx.scene.media.AudioClip;
import com.example.miniproyecto_escritura_rapida.view.GameStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {
    private AudioClip startSound;

    @FXML
    public void initialize() {
        startSound = new AudioClip(
                getClass().getResource("/com/example/miniproyecto_escritura_rapida/Sounds/start-sound.mp3").toExternalForm()
        );
    }

    @FXML
    private void handlePlay(ActionEvent event) {
        startSound.play();
        GameStage.loadScene("game-view.fxml");
    }

    @FXML
    private void handleHowToPlay(ActionEvent event) {
        startSound.play();
        GameStage.loadScene("how-to-play-view.fxml");
    }
}