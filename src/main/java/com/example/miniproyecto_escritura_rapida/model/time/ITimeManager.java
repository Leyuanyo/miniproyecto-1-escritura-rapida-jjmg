package com.example.miniproyecto_escritura_rapida.model.time;

/**
 * Interface defining the time management contract for the Escritura Rapida typing game.
 * Provides methods for initializing, updating, and querying the countdown timer
 * for each game level.
 *
 * @author Juan José Morera Gómez
 * @version 1.0
 * @since 1.0
 * @see TimeManager
 */
public interface ITimeManager {

    /**
     * Initializes the countdown timer for the given level.
     * The time assigned decreases every 5 levels by a fixed reduction amount,
     * down to a minimum value.
     *
     * @param level the current game level used to calculate the time for this level
     * @since 1.0
     */
    void initTime(int level);

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
     * Returns the remaining time for the current level in seconds.
     *
     * @return the time left in seconds
     * @since 1.0
     */
    int getTimeLeft();
}