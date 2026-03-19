package com.example.miniproyecto_escritura_rapida;

import com.example.miniproyecto_escritura_rapida.view.GameStage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Entry point of the Escritura Rapida typing game.
 * Extends {@link Application} to launch the JavaFX application,
 * initializes the primary stage through {@link GameStage},
 * and loads the main menu scene.
 *
 * @author Juan José Morera Gómez
 * @version 1.0
 * @since 1.0
 * @see GameStage
 * @see javafx.application.Application
 */
public class Main extends Application {

    /**
     * Main entry point of the Java application.
     * Launches the JavaFX application by calling {@link Application#launch(String...)}.
     *
     * @param args command-line arguments passed to the application
     * @since 1.0
     */
    public static void main(String[] args) {launch(args);}

    /**
     * JavaFX application start method.
     * Sets the primary stage through {@link GameStage#setPrimaryStage(Stage)}
     * and loads the main menu scene.
     *
     * @param primaryStage the primary stage provided by the JavaFX runtime
     * @throws IOException if the FXML file for the main menu cannot be loaded
     * @since 1.0
     * @see GameStage#setPrimaryStage(Stage)
     * @see GameStage#loadScene(String)
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        GameStage.setPrimaryStage(primaryStage);
        GameStage.loadScene("main-menu-view.fxml");    }
}