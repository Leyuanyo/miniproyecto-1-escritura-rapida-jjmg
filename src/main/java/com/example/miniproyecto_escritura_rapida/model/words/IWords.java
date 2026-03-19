package com.example.miniproyecto_escritura_rapida.model.words;

/**
 * Interface defining the word management contract for the Escritura Rapida typing game.
 * Provides methods for generating random words and validating
 * the player's input against the current word.
 *
 * @author Juan José Morera Gómez
 * @version 1.0
 * @since 1.0
 * @see Words
 */
public interface IWords {

    /**
     * Generates and returns a random word from the word bank
     * for the player to type.
     *
     * @return a randomly selected word as a {@code String}
     * @since 1.0
     */
    String generateWord();

    /**
     * Validates the player's input against the current word.
     *
     * @param userWord the word typed by the player
     * @return {@code true} if the player's input matches the current word,
     *         {@code false} otherwise
     * @since 1.0
     */
    Boolean validateWord(String userWord);

}
