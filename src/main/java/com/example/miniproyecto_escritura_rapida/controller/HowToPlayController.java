package com.example.miniproyecto_escritura_rapida.controller;

import javafx.scene.media.AudioClip;
import com.example.miniproyecto_escritura_rapida.view.GameStage;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;

/**
 * Controller for the How To Play screen.
 * Handles the display of game instructions and navigation
 * back to the main menu when the ESCAPE key is pressed.
 *
 * @author Juan José Morera Gómez
 * @version 1.0
 * @since 1.0
 * @see GameStage
 */
public class HowToPlayController {

    /** Sound played when the player presses the ESCAPE key. */
    private AudioClip escSound;

    /**
     * Initializes the How To Play controller.
     * Loads the escape sound and sets up a key listener on the current scene
     * that returns the player to the main menu when ESCAPE is pressed.
     *
     * @since 1.0
     * @see GameStage#getPrimaryStage()
     * @see GameStage#loadScene(String)
     */
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