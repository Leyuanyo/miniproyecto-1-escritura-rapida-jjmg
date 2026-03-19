package com.example.miniproyecto_escritura_rapida.model.game;

/**
 * Interface defining the core game logic contract for the Escritura Rapida typing game.
 * Provides methods for level management, word validation, time control,
 * and win/lose condition checking.
 *
 * @author Juan José Morera Gómez
 * @version 1.0
 * @since 1.0
 * @see Game
 */
public interface IGame {

    /**
     * Starts the current level by initializing the timer
     * and generating a new word for the player to type.
     *
     * @return the word the player must type in this level
     * @since 1.0
     */
    String startLevel();

    /**
     * Checks whether the player has won the game.
     *
     * @return {@code true} if the player has won, {@code false} otherwise
     * @since 1.0
     */
    boolean isGameWon();

    /**
     * Validates the player's answer against the current word.
     * If correct, advances the game to the next level.
     *
     * @param userWord the word typed by the player
     * @return {@code true} if the answer is correct, {@code false} otherwise
     * @since 1.0
     */
    boolean checkAnswer(String userWord);

    /**
     * Returns the current level of the game.
     *
     * @return the current level
     * @since 1.0
     */
    int getLevel();

    /**
     * Returns the remaining time for the current level in seconds.
     *
     * @return the time left in seconds
     * @since 1.0
     */
    int getTimeLeft();

    /**
     * Returns whether the game has ended in a loss.
     *
     * @return {@code true} if the game is over, {@code false} otherwise
     * @since 1.0
     */
    boolean isGameOver();

    /**
     * Decrements the remaining time by one second.
     *
     * @since 1.0
     */
    void decrementTime();

    /**
     * Checks whether the countdown timer has reached zero.
     *
     * @return {@code true} if time is up, {@code false} otherwise
     * @since 1.0
     */
    boolean isTimeUp();

    /**
     * Performs the final word validation when the timer reaches zero.
     * If correct, advances to the next level. If incorrect, ends the game.
     *
     * @param userWord the word typed by the player at the moment time ran out
     * @return {@code true} if the word was correct and the player is saved,
     *         {@code false} if the word was incorrect and the game is over
     * @since 1.0
     */
    boolean onTimeUp(String userWord);
}