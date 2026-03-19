package com.example.miniproyecto_escritura_rapida.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Centralized scene manager for the Escritura Rapida typing game.
 * Manages the primary JavaFX {@link Stage} and provides static methods
 * for loading and switching between FXML scenes throughout the application.
 *
 * @author Juan José Morera Gómez
 * @version 1.0
 * @since 1.0
 * @see javafx.stage.Stage
 * @see javafx.fxml.FXMLLoader
 */
public class GameStage {

    /** The primary stage of the JavaFX application. */
    private static Stage primaryStage;

    /**
     * Returns the primary stage of the application.
     *
     * @return the primary {@link Stage} instance
     * @since 1.0
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Sets and configures the primary stage of the application.
     * Sets the window title, disables resizing, and assigns the application icon.
     *
     * @param stage the primary {@link Stage} provided by the JavaFX runtime
     * @since 1.0
     */
    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Escritura Rápida");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(
                new Image(GameStage.class.getResourceAsStream(
                        "/com/example/miniproyecto_escritura_rapida/Images/game-icon.png"
                ))
        );
    }

    /**
     * Loads and displays a new scene from the specified FXML file.
     * The FXML file must be located in the resources directory of the application.
     * If the file cannot be loaded, the stack trace is printed to the console.
     *
     * @param fxmlName the name of the FXML file to load, including the extension
     *                 (e.g., {@code "game-view.fxml"})
     * @since 1.0
     * @see FXMLLoader
     */
    public static void loadScene(String fxmlName) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    GameStage.class.getResource(
                            "/com/example/miniproyecto_escritura_rapida/" + fxmlName
                    )
            );
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}