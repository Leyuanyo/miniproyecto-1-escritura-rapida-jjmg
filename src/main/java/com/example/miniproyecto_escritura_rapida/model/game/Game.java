package com.example.miniproyecto_escritura_rapida.model.game;
import com.example.miniproyecto_escritura_rapida.model.time.TimeManager;
import com.example.miniproyecto_escritura_rapida.model.words.Words;

/**
 * Main game logic class for the Escritura Rapida typing game.
 * Manages the game state including the current level, word validation,
 * time control, and win/lose conditions.
 * Delegates time management to {@link TimeManager} and
 * word generation to {@link Words}.
 *
 * @author Juan José Morera Gómez
 * @version 1.0
 * @since 1.0
 * @see IGame
 * @see TimeManager
 * @see Words
 */
public class Game implements IGame {

    /**
     * The level at which the player wins the game.
     * The player must complete level 45 to trigger the win condition.
     */
    private static final int WINNING_LEVEL = 45;

    /** The current level of the game. */
    private int level;

    /** Whether the game has ended in a loss. */
    private boolean gameOver;

    /** The time manager responsible for tracking and updating the countdown. */
    private TimeManager timeManager;

    /** The word bank responsible for generating and validating words. */
    private Words wordBank;

    /**
     * Constructs a new Game instance.
     * Initializes the level to 1, sets game over to false,
     * and creates new instances of {@link Words} and {@link TimeManager}.
     *
     * @since 1.0
     */
    public Game() {
        level = 1;
        gameOver = false;
        wordBank = new Words();
        timeManager = new TimeManager();
    }

    /**
     * Starts the current level by initializing the timer
     * and generating a new word for the player to type.
     *
     * @return the word the player must type in this level
     * @since 1.0
     * @see TimeManager#initTime(int)
     * @see Words#generateWord()
     */
    @Override
    public String startLevel() {
        timeManager.initTime(level);
        return wordBank.generateWord();
    }

    /**
     * Checks whether the player has won the game.
     * The game is won when the current level exceeds {@code WINNING_LEVEL}.
     *
     * @return {@code true} if the player has won, {@code false} otherwise
     * @since 1.0
     */
    @Override
    public boolean isGameWon() {
        return level > WINNING_LEVEL;
    }

    /**
     * Validates the player's answer against the current word.
     * If correct, increments the level by one.
     *
     * @param userWord the word typed by the player
     * @return {@code true} if the answer is correct, {@code false} otherwise
     * @since 1.0
     * @see Words#validateWord(String)
     */
    @Override
    public boolean checkAnswer(String userWord) {
        if (wordBank.validateWord(userWord)) {
            level++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the current level of the game.
     *
     * @return the current level
     * @since 1.0
     */
    @Override
    public int getLevel() { return level; }

    /**
     * Returns the remaining time for the current level.
     *
     * @return the time left in seconds
     * @since 1.0
     * @see TimeManager#getTimeLeft()
     */
    @Override
    public int getTimeLeft() {
        return timeManager.getTimeLeft();
    }

    /**
     * Returns whether the game has ended in a loss.
     *
     * @return {@code true} if the game is over, {@code false} otherwise
     * @since 1.0
     */
    @Override
    public boolean isGameOver() { return gameOver; }

    /**
     * Decrements the remaining time by one second.
     * Delegates to {@link TimeManager#decrementTime()}.
     *
     * @since 1.0
     * @see TimeManager#decrementTime()
     */
    @Override
    public void decrementTime() {
        timeManager.decrementTime();
    }

    /**
     * Checks whether the countdown timer has reached zero.
     *
     * @return {@code true} if time is up, {@code false} otherwise
     * @since 1.0
     * @see TimeManager#isTimeUp()
     */
    public boolean isTimeUp() {
        return timeManager.isTimeUp();
    }

    /**
     * Performs the final word validation when the timer reaches zero.
     * If the player's input is correct, the level is incremented.
     * If incorrect, the game is marked as over.
     *
     * @param userWord the word typed by the player at the moment time ran out
     * @return {@code true} if the word was correct and the player is saved,
     *         {@code false} if the word was incorrect and the game is over
     * @since 1.0
     * @see Words#validateWord(String)
     */
    @Override
    public boolean onTimeUp(String userWord) {
        if (wordBank.validateWord(userWord)) {
            level++;
            return true;
        } else {
            gameOver = true;
            return false;
        }
    }

}