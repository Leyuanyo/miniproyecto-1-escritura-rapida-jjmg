package com.example.miniproyecto_escritura_rapida.model.game;

public interface IGame {
    String startLevel();
    boolean isGameWon();
    boolean checkAnswer(String userWord);
    int getLevel();
    int getTimeLeft();
    boolean isGameOver();
    void decrementTime();
    boolean isTimeUp();
    boolean onTimeUp(String userWord);
}