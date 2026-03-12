package com.example.miniproyecto_escritura_rapida.model.time;

public class TimeManager implements ITimeManager {

    private static final int INITIAL_TIME = 20;
    private static final int MIN_TIME = 2;
    private static final int LEVELS_PER_REDUCTION = 5;
    private static final int TIME_REDUCTION = 2;

    private int timeLeft;

    public TimeManager() {
        timeLeft = INITIAL_TIME;
    }

    @Override
    public void initTime(int level) {
        int reductions = (level - 1) / LEVELS_PER_REDUCTION;
        timeLeft = Math.max(MIN_TIME, INITIAL_TIME - reductions * TIME_REDUCTION);
    }

    @Override
    public void decrementTime() {
        timeLeft--;
    }

    @Override
    public boolean isTimeUp() {
        return timeLeft <= 0;
    }

    @Override
    public int getTimeLeft() {
        return timeLeft;
    }
}