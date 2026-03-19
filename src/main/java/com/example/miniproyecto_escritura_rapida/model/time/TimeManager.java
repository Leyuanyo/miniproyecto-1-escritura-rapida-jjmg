package com.example.miniproyecto_escritura_rapida.model.time;

/**
 * Implementation of the {@link ITimeManager} interface.
 * Manages the countdown timer for each level of the Escritura Rapida typing game.
 * The available time decreases every 5 levels by 2 seconds,
 * with a minimum of 2 seconds per level.
 *
 * @author Juan José Morera Gómez
 * @version 1.0
 * @since 1.0
 * @see ITimeManager
 */
public class TimeManager implements ITimeManager {

    /** The initial time in seconds assigned at the start of the game. */
    private static final int INITIAL_TIME = 20;

    /** The minimum time in seconds a level can have. */
    private static final int MIN_TIME = 2;

    /** The number of levels completed before the time is reduced. */
    private static final int LEVELS_PER_REDUCTION = 5;

    /** The amount of seconds subtracted from the timer every reduction step. */
    private static final int TIME_REDUCTION = 2;

    /** The remaining time in seconds for the current level. */
    private int timeLeft;

    /**
     * Constructs a new TimeManager instance.
     * Initializes the remaining time to {@code INITIAL_TIME}.
     *
     * @since 1.0
     */
    public TimeManager() {
        timeLeft = INITIAL_TIME;
    }

    /**
     * Initializes the countdown timer for the given level.
     * Calculates the number of reductions based on the level and applies them
     * to the initial time, ensuring the result never falls below {@code MIN_TIME}.
     *
     * @param level the current game level used to calculate the available time
     * @since 1.0
     */
    @Override
    public void initTime(int level) {
        int reductions = (level - 1) / LEVELS_PER_REDUCTION;
        timeLeft = Math.max(MIN_TIME, INITIAL_TIME - reductions * TIME_REDUCTION);
    }

    /**
     * Decrements the remaining time by one second.
     *
     * @since 1.0
     */
    @Override
    public void decrementTime() {
        timeLeft--;
    }

    /**
     * Checks whether the countdown timer has reached zero.
     *
     * @return {@code true} if time is up, {@code false} otherwise
     * @since 1.0
     */
    @Override
    public boolean isTimeUp() {
        return timeLeft <= 0;
    }

    /**
     * Returns the remaining time for the current level in seconds.
     *
     * @return the time left in seconds
     * @since 1.0
     */
    @Override
    public int getTimeLeft() {
        return timeLeft;
    }
}