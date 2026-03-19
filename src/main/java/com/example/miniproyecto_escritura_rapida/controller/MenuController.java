package com.example.miniproyecto_escritura_rapida.controller;

import javafx.scene.media.AudioClip;
import com.example.miniproyecto_escritura_rapida.view.GameStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Controller for the Main Menu screen.
 * Handles navigation to the game screen and the how to play screen.
 *
 * @author Juan José Morera Gómez
 * @version 1.0
 * @since 1.0
 * @see GameStage
 */
public class MenuController {

    /** Sound played when a menu button is clicked. */
    private AudioClip startSound;

    /**
     * Initializes the Menu controller.
     * Loads the start sound audio resource.
     *
     * @since 1.0
     */
    @FXML
    public void initialize() {
        startSound = new AudioClip(
                getClass().getResource("/com/example/miniproyecto_escritura_rapida/Sounds/start-sound.mp3").toExternalForm()
        );
    }

    /**
     * Handles the Play button click event.
     * Plays the start sound and loads the main game scene.
     *
     * @param event the ActionEvent triggered by clicking the Play button
     * @since 1.0
     * @see GameStage#loadScene(String)
     */
    @FXML
    private void handlePlay(ActionEvent event) {
        startSound.play();
        GameStage.loadScene("game-view.fxml");
    }

    /**
     * Handles the How To Play button click event.
     * Plays the start sound and loads the how to play scene.
     *
     * @param event the ActionEvent triggered by clicking the How To Play button
     * @since 1.0
     * @see GameStage#loadScene(String)
     */
    @FXML
    private void handleHowToPlay(ActionEvent event) {
        startSound.play();
        GameStage.loadScene("how-to-play-view.fxml");
    }
}