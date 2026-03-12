package com.example.miniproyecto_escritura_rapida.model.game;
import com.example.miniproyecto_escritura_rapida.model.time.TimeManager;

import com.example.miniproyecto_escritura_rapida.model.words.Words;

public class Game implements IGame {


    private static final int WINNING_LEVEL = 45;


    private int level;
    private boolean gameOver;
    private TimeManager timeManager;
    private Words wordBank;

    public Game() {
        level = 1;
        gameOver = false;
        wordBank = new Words();
        timeManager = new TimeManager();
    }

    @Override
    public String startLevel() {
        timeManager.initTime(level);
        return wordBank.generateWord();
    }

    @Override
    public boolean isGameWon() {
        return level > WINNING_LEVEL;
    }

    @Override
    public boolean checkAnswer(String userWord) {
        if (wordBank.validateWord(userWord)) {
            level++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getLevel() { return level; }

    @Override
    public int getTimeLeft() {
        return timeManager.getTimeLeft();
    }

    @Override

    public boolean isGameOver() { return gameOver; }

    @Override

    public void decrementTime() {
        timeManager.decrementTime();
    }

    public boolean isTimeUp() {
        return timeManager.isTimeUp();
    }

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