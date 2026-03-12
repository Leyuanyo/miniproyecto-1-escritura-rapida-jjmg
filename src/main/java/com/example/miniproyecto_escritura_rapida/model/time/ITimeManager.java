package com.example.miniproyecto_escritura_rapida.model.time;

public interface ITimeManager {
    void initTime(int level);
    void decrementTime();
    boolean isTimeUp();
    int getTimeLeft();
}